# syntax=docker/dockerfile:1.4
FROM rubensa/ubuntu-tini-dev as base
# Architecture component of TARGETPLATFORM (platform of the build result)
ARG TARGETARCH
# Architecture component of TARGETPLATFORM (platform of the build result)
ARG TARGETARCH
# Install Java
ARG JAVA_VERSION=17
ARG DISTRIBUTION_SUFFIX=mandrel
ARG DISTRIBUTION_VERSION=23.0
RUN <<EOT
#!/bin/bash -l
echo "# Installing Java..."
export SDKMAN_DIR=/opt/sdkman
. /opt/sdkman/bin/sdkman-init.sh
export JAVA_VERSION=${JAVA_VERSION}
export DISTRIBUTION_SUFFIX=${DISTRIBUTION_SUFFIX}
export DISTRIBUTION_VERSION=${DISTRIBUTION_VERSION}
export JAVA_INSTALL_VERSION=$(sdk list java | grep -o "${DISTRIBUTION_VERSION}[0-9\\.]*\\.r${JAVA_VERSION}-${DISTRIBUTION_SUFFIX}" | head -1)
sdk install java $JAVA_INSTALL_VERSION || true
sudo mkdir -p /usr/lib/jvm
sudo ln -s /opt/sdkman/candidates/java/$JAVA_INSTALL_VERSION /usr/lib/jvm/$JAVA_VERSION
sdk default java $JAVA_INSTALL_VERSION
EOT

FROM base
# Create maven repository directory so it is owned by the user
RUN mkdir -p /home/${USER_NAME}/.m2/repository
# Create maven wrapper directory so it is owned by the user
RUN mkdir -p /home/${USER_NAME}/.m2/wrapper
# Keep container running (for use in VSCode)
CMD [ "tail", "-f", "/dev/null" ]