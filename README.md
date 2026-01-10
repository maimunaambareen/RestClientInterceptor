Youtube reference: https://www.youtube.com/watch?v=nedhXAU8U4s

The Spring Framework provides the following choices for making calls to REST endpoints:

RestClient — synchronous client with a fluent API

WebClient — non-blocking, reactive client with fluent API

RestTemplate — synchronous client with template method API, now deprecated in favor of RestClient

HTTP Service Clients — annotated interface backed by generated proxy

### When RestTemplate is deprecated, instead of using WebClient (which is reactive), RestClient is a good option for making calls to REST endpoint.
