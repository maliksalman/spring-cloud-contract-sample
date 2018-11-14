package messaging

org.springframework.cloud.contract.spec.Contract.make {
    label 'person_added_event'
    input {
        triggeredBy('personAddedIsCalled()')
    }
    outputMessage {
        sentTo('persons.topic')
        body([
          name: $(consumer('super-man'), producer(anyNonEmptyString())),
          age: $(consumer('35'), producer(anInteger())),
          id: $(consumer('56dbf39c-a7bf-4be2-863a-594baadb243d'), producer(regex('[a-z0-9-]+'))),
          addedAt: $(consumer('2016-11-13T20:20:50.633+0500'), producer(regex('([0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(\\.\\d{3})?(Z|[+-][0-9]{4})')))
        ])
        headers {
            messagingContentType(applicationJson())
        }
    }
}
