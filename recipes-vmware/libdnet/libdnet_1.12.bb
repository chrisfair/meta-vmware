DESCRIPTION = "simplified, portable interface to several low-level networking routines"
SECTION = "libs" 
HOMEPAGE = "http://libdnet.sourceforge.net/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
SRC_URI = "http://libdnet.googlecode.com/files/${P}.tgz"
SRC_URI[md5sum] = "9253ef6de1b5e28e9c9a62b882e44cc9"
SRC_URI[sha256sum] = "83b33039787cf99990e977cef7f18a5d5e7aaffc4505548a83d31bd3515eb026"

S = "${WORKDIR}/${P}"
PR = "r2"

inherit autotools binconfig  

EXTRA_AUTORECONF += " -I ${S}/config"

