#!/bin/bash -e
if ! docker --version
then
  mkdir qaOtus
  cd qaOtus
  sudo yum install -y yum-utils
  sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
  sudo yum install docker-ce docker-ce-cli containerd.io
  sudo systemctl start docker
  curl -s https://aerokube.com/cm/bash | bash
  ./cm selenoid start --vnc --browsers "chrome" --last-versions 3 --args "-limit 4" --force --use-drivers
  ./cm selenoid-ui start --use-drivers
else
  mkdir qaOtus
  cd qaOtus
  curl -s https://aerokube.com/cm/bash | bash
  ./cm selenoid start --vnc --browsers "chrome" --last-versions 3 --args "-limit 4" --force --use-drivers
  ./cm selenoid-ui start --use-drivers
fi