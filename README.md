# Demp API

## Helm Charts

`helm install demoapi ./helm/ `

`helm upgrade demoapi ./helm/ `

The purpose of that API was to practice Helm Charts. 
Communication between Pods seems to work fine. 
`demoapi-api1` can send requests to `demoapi-api2` via REST API calls.
SpringBoot API uses Rest Template to call endpoint `/api/person/items/{personId}`

