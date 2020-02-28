FROM oracle/graalvm-ce:20.0.0-java8 AS builder
#FROM oracle/graalvm-ce:20.0.0 AS builder
RUN gu install native-image
WORKDIR /target
COPY target/ ./
RUN native-image \
      --static \
      --class-path simple-graalvm-native-image-0.0.1-SNAPSHOT.jar \
      -jar simple-graalvm-native-image-0.0.1-SNAPSHOT.jar \
      sayhello

FROM scratch
WORKDIR /
COPY --from=builder /target/sayhello /sayhello
ENTRYPOINT ["./sayhello"]
