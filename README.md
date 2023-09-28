# Project quarkus-resteasy-reactive-bug

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

This project contains a basic code sample to show **[PathParam URL encoded in quarkus-resteasy-reactive since quarkus 3.2.x](https://github.com/quarkusio/quarkus/issues/35960)** bug.

The code is configured to use Quarkus 3.4.1 version with quarkus-resteasy-reactive.

I you run the provided test it (running `./mvnw test`) it will fail.

You can check that it works if you replace `quarkus.platform.version` from `3.4.1` to `3.1.3.Final` in [pom.xml](pom.xml).

It will also work if you keep `quarkus.platform.version` as `3.4.1` but use the non-reactive **quarkus-resteasy** by replacing `quarkus-resteasy-reactive` with `quarkus-resteasy` and `quarkus-resteasy-reactive-jackson` with `quarkus-resteasy-jackson` in [pom.xml](pom.xml).

## Development

This repo is aimed to be opened in **[VSCode](https://code.visualstudio.com/)** with the **[Remote Development](https://code.visualstudio.com/docs/remote/remote-overview)** extension pack installed.

The development is done inside a **[Docker container](https://docker.com/)** that installs and configures the required tools on first run (the first time the Docker image is build might take some time).

Please, make sure you have **VSCode** with the **Remote Development extension pack** and **Docker** installed and working on your system before cloning the respository then clone de repository:

`git clone https://github.com/rubensa/quarkus-resteasy-reactive-bug.git`

For detailed instructions see: **[Developing inside a Container](https://code.visualstudio.com/docs/remote/containers)**.

## Project Organization

    ├── .devcontainer     <- VSCode Remote Development configuration
    │
    ├── src               <- Application source code
    │
    ├── .mvn              <- Maven Wrapper Java library and its properties file
    │
    ├── .gitgnore         <- Git ignored files
    ├── mvnw              <- Maven Wrapper (Linux)
    ├── mvnw.cmd          <- Maven Wrapper (Windows)
    ├── pom.xml           <- Maven dependencies
    └── README.md         <- This file

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-resteasy-reactive-bug-0.0.1-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- YAML Configuration ([guide](https://quarkus.io/guides/config#yaml)): Use YAML to configure your Quarkus application
- Lombok ([guide](https://projectlombok.org/features/all)): A Java library to reduce boilerplate code.

## Provided Code

### YAML Config

Configure your application with YAML

[Related guide section...](https://quarkus.io/guides/config-reference#configuration-examples)

The Quarkus application configuration is located in `src/main/resources/application.yml`.

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
