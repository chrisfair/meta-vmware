DECRIPTION = "open-vmware-tools"
SECTION = "vmware-tools"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=751419260aa954499f7abaabaa882bbe \
                    file://open-vm-tools/COPYING;md5=751419260aa954499f7abaabaa882bbe"" 
PR = "r1"

RREPLACES_${PN} = "open-vmware-tools"
RCONFLICTS_${PN} = "open-vmware-tools"

SRC_URI = "git://github.com/vmware/open-vm-tools.git;protocol=https;branch=master;nobranch=1"

S = "${WORKDIR}/open-vm-tools-stable-${PV}/open-vm-tools"

DEPENDS = "virtual/kernel glib-2.0 util-linux libdnet procps openssl"
RDEPENDS_${PN} = "util-linux libdnet"

inherit module-base kernel-module-split autotools systemd

# from module.bbclass...
addtask make_scripts after do_patch before do_compile
do_make_scripts[lockfiles] = "${TMPDIR}/kernel-scripts.lock"
do_make_scripts[deptask] = "do_populate_sysroot"

# add all splitted modules to PN RDEPENDS, PN can be empty now
KERNEL_MODULES_META_PACKAGE = "${PN}"
#

SYSTEMD_SERVICE_${PN} = "vmtoolsd.service"

EXTRA_OECONF = "--without-icu --disable-multimon --disable-docs --disable-tests \
		--without-gtk2 --without-gtkmm \
		--with-linuxdir=${STAGING_KERNEL_DIR} --without-kernel-modules"

EXTRA_OECONF += "--enable-deploypkg=no"
EXTRA_OECONF += "--without-xerces"

EXTRA_OECONF += "${@bb.utils.contains('DISTRO_FEATURES', 'pam', '', '--without-pam', d)} \
                 ${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', '--without-x', d)}"

EXTRA_OEMAKE = "MODULES_DIR=/lib/modules/${KERNEL_VERSION}/kernel KERNEL_RELEASE=${KERNEL_VERSION}"

CFLAGS += '-Wno-error=deprecated-declarations'

FILES_${PN} += "/usr/lib/open-vm-tools/plugins/vmsvc/lib*.so \
		/usr/lib/open-vm-tools/plugins/common/lib*.so \
    ${sysconfdir}/vmware-tools/tools.conf"
FILES_${PN}-locale += "/usr/share/open-vm-tools/messages"
FILES_${PN}-dev += "/usr/lib/open-vm-tools/plugins/common/lib*.la"
FILES_${PN}-dbg += "/usr/lib/open-vm-tools/plugins/common/.debug \
		    /usr/lib/open-vm-tools/plugins/vmsvc/.debug"

CONFFILES_${PN} += "${sysconfdir}/vmware-tools/tools.conf"

do_install:append() {
    install -d ${D}${systemd_unitdir}/system ${D}${sysconfdir}/vmware-tools
    install -m 644 ${WORKDIR}/*.service ${D}${systemd_unitdir}/system
# install -m 0644 ${WORKDIR}/tools.conf ${D}${sysconfdir}/vmware-tools/tools.conf
}

do_configure:prepend() {
    export CUSTOM_PROCPS_NAME=procps
    export CUSTOM_PROCPS_LIBS=-L${STAGING_LIBDIR}/libprocps.so
    export CUSTOM_SSL_CPPFLAGS=-I${STAGING_INCDIR}
}
