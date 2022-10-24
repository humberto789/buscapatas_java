## Buscapatas
This project uses the following technologies:
- Java
- Maven
- Spring-boot
- MySQL
- Docker

## Project setup

### 1. Clone this repository
```bash
$ git clone git@github.com:humberto789/buscapatas_java.git
```

### 2. Install Docker in your machine
If you're in Ubuntu:
https://docs.docker.com/desktop/install/ubuntu/

If you're in Windows:
https://docs.docker.com/desktop/install/windows-install/

### 3. Rename the "sample.env" file to ".env"
```bash
$ cp sample.env .env
```

### 4. Run
```bash
$ docker compose up --build -d
```
You can also use this command to **update** changes you made in your code.

The first time you execute this command, it's completely normal that building process take more than 1 minute to execute. That's because Maven is installing up the dependencies listed in `pom.xml`.

### 5. Stop
Since `-d` flag specifies docker to run in background, you can stop docker using this following command
```bash
$ docker compose stop
```

If you wanna kill the docker volumes, that include MySQL data, you can execute this same command with the `-v` flag.
