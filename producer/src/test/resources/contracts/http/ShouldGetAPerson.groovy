package http

org.springframework.cloud.contract.spec.Contract.make {

    request {
        method 'GET'
        url '/persons/101'
    }
    response {
        status 200
        body([
                name: $(consumer("super-man"), producer(anyNonEmptyString())),
                age: $(consumer("35"), producer(anInteger())),
                date: $(consumer(new java.util.Date().toInstant().toString()), producer(regex('([0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(\\.\\d{3})?(Z|[+-][0-9]{4})')))
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
