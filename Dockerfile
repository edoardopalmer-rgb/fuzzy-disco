FROM maven:3.8.8-eclipse-temurin-17

USER root

# installa curl, wget e chrome
RUN apt-get update && \
    apt-get install -y curl wget gnupg2 && \
    curl -L -o /tmp/google-chrome.deb https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    apt-get install -y /tmp/google-chrome.deb && \
    rm /tmp/google-chrome.deb && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# copia il progetto
COPY . /app

# di default esegue i test
ENTRYPOINT ["mvn"]
CMD ["test"]
