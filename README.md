# Getting Started

## Cliente Blocking vs. Non-Blocking

É um requisito comum em aplicativos da Web fazer chamadas HTTP para outros serviços. Portanto, precisamos de uma ferramenta de cliente da web. 

O RestTemplate usa a API do Java Servlet e, portanto, é síncrono e bloqueia. Contrariamente, o WebClient é assíncrono e não bloqueará o encadeamento de execução enquanto aguarda a resposta retornar. Somente quando a resposta estiver pronta, a notificação será produzida.

RestTemplate ainda será usado. Em alguns casos, a abordagem sem bloqueio usa muito menos recursos do sistema em comparação com o bloqueio. Portanto, nesses casos, o WebClient é uma opção preferível.


### Reference Documentation

* [Exemplo da aplicacao] (https://www.baeldung.com/spring-webclient-resttemplate)

* [Threads Vs Queues] (https://medium.com/omarelgabrys-blog/threads-vs-queues-a71e8dc30156)