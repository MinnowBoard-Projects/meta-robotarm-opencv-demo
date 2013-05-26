DESCRIPTION = "Cross-Platform GUI Library"
SECTION = "devel/python"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://docs/licence.txt;md5=fe0b3b96f56813aa7819bff294868cb1"
#TODO deal with wxWidgets license exception

DEPENDS = "gtk+"
RDEPENDS_${PN} = "jpeg tiff libpng"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxpython/wxPython-src-${PV}.tar.bz2"

SRC_URI[md5sum] = "8c06c5941477beee213b4f2fa78be620"
SRC_URI[sha256sum] = "1f3f153d9f1504c6ce2d2c4b23e940b8f58b81f4cba35cda1a5bb31142243cd0"

S = "${WORKDIR}/wxPython-src-${PV}"

inherit pkgconfig

EXTRA_OECONF = "--build=${BUILD_SYS} \
                --host=${HOST_SYS} \
                --target=${TARGET_SYS} \
                --prefix=${prefix} \
                --exec_prefix=${exec_prefix} \
                --enable-unicode"
EXTRA_OEMAKE = ""

do_configure() {
	${S}/configure ${EXTRA_OECONF}
}

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
	ln -s wx-2.8/wx ${D}${includedir}/wx
	cp ${D}/usr/lib/wx/include/i586-poky-linux-gtk2-unicode-release-2.8/wx/setup.h ${D}${includedir}/wx/
}

FILES_${PN} += "/usr/lib/wx/config/i586-poky-linux-gtk2-unicode-release-2.8"
FILES_${PN} += "/usr/lib/wx/include/i586-poky-linux-gtk2-unicode-release-2.8/wx/setup.h"
FILES_${PN} += "/usr/share/bakefile/presets/wx.bkl \
                /usr/share/bakefile/presets/wx_win32.bkl \
                /usr/share/bakefile/presets/wx_unix.bkl"
