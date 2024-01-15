cd C:\repo\cryptorealtimeplatform\kafka

docker compose up -d

#docker-compose exec kafka-kafka-1 kafka-topics.sh --create --topic crypto_topic --partitions 1 --replication-factor 1 --bootstrap-server kafka:9092