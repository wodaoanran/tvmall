FROM openjdk:8-jre
LABEL maintainer="java202004"
RUN apt-get update && appt-get install procps
COPY tvmallbs_provider-assembly.tar.gz /tvmallbs_provider-assembly.tar.gz
WORKDIR /
RUN tar -zxvf tvmallbs_provider-assembly.tar.gz
WORKDIR tvmallbs_provider
ENTRYPOINT ["bin/server.sh","start"]
EXPOSE 20880