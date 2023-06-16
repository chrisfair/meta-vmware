SUMMARY = "Extra VMWare specific configuration files"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r1"

SRC_URI = "file://virtual-net.rules"

libexecdir = "${base_libdir}/udev"

do_install () {
    install -d ${D}${libexecdir}/rules.d
    install -m 0644 ${WORKDIR}/virtual-net.rules ${D}${libexecdir}/rules.d/79-virtual-net.rules
}

RDEPENDS_${PN} = "udev"
FILES_${PN} = "${libexecdir}/rules.d"
