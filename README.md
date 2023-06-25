# aws_study_project02

### To run LocalStack
`docker run --rm -p 4566:4566 -p 4571:4571 localstack/localstack -e "SERVICES=sns, sqs, dynamodb, s3"`
#### Environmment
`spring.profiles.active=local`
