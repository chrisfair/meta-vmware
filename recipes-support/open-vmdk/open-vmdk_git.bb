SUMMARY = "open-vmdk"
DESCRIPTION = "Tools for vmware disk images"
HOMEPAGE = "https://github.com/vmware/open-vmdk"
SECTION = "base"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://vmdk/mkdisk.c;endline=14;md5=443cd7a9387ca4ac2f9d29a03c7b6f1f"

SRCREV = "82eb7268e78cc32907573b713569e1331c571ce5"
SRC_URI = "git://github.com/vmware/open-vmdk;protocol=https;branch=master"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake install DESTDIR=${D}
}


FILES_${PN} += "${binddir}/*"
