DESCRIPTION = "robot-opencv-demo - Contains a basic X11 environment that boots to a matchbox-terminal and allows you to run the OWI Robot Arm & OpenCV MinnowBoard demo."

IMAGE_FEATURES += "splash package-management x11-base ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "opencv-apps opencv-dev python-opencv python-modules python-pyusb python-wxpython mesa-demos"
