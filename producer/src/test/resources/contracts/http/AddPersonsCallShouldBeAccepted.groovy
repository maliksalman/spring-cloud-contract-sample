package http

org.springframework.cloud.contract.spec.Contract.make {

    request {
        method 'POST'
        url '/persons'
        body(
            name: $(producer("Bruce Wayne"), consumer(anyNonEmptyString())),
            city: $(producer("Gotham City"), consumer(anyNonEmptyString())),
            age: $(producer("40"), consumer(anInteger()))
        )
        headers {
            contentType(applicationJsonUtf8())
        }
    }
    response {
        status 200
        body(
            $(consumer('56dbf39c-a7bf-4be2-863a-594baadb243d'), producer(regex('[a-z0-9-]+')))
        )
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
