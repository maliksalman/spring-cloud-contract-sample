package http

org.springframework.cloud.contract.spec.Contract.make {

    request {
        method 'POST'
        url '/persons'
        body(
            name: $(producer("super-man"), consumer(anyNonEmptyString())),
            age: $(producer("35"), consumer(anInteger()))
        )
        headers {
            contentType(applicationJsonUtf8())
        }
    }
    response {
        status 200
    }
}
