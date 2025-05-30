<h1>💱 Aplicação Conversor de Moedas </h1>
<p>Este projeto foi desenvolvido como parte de um <strong>challenge do programa Oracle Next Education (ONE)</strong> em parceria com a <strong>Alura</strong>, com o objetivo de praticar os fundamentos da linguagem <strong>Java</strong> e aplicar conceitos como requisições HTTP, tratamento de arquivos e modularização de código.
</p>
<p>A aplicação é executada via terminal e permite ao usuário realizar <strong>conversões de moedas em tempo real</strong>, consultando uma <strong>API externa de câmbio</strong>. O usuário escolhe as moedas de origem e destino, informa o valor a ser convertido e recebe o resultado instantaneamente.
</p>
<p>Além disso, cada conversão realizada é <strong>registrada em um arquivo local de histórico</strong>, permitindo o acompanhamento das operações feitas durante o uso da aplicação.
</p>
<br>
<img src="https://github.com/user-attachments/assets/7ca28458-cf9c-471c-81d3-de1e48040d8c" alt="Demonstração da aplicação" style="max-width: 100%; height: auto;" />
<br>
<hr />




<h2>📦 Estrutura do Projeto</h2>
<ul>
  <li><strong>Principal.java</strong>: Interface de interação via terminal.</li>
  <li><strong>api/</strong>: Pacote responsável pela comunicação com a API.
    <ul>
      <li>ClienteHttpCotacao.java</li>
      <li>RequisicaoCotacao.java</li>
      <li>RespostaCotacaoCompleta.java</li>
      <li>RespostaCotacaoParser.java</li>
      <li>ConfiguracoesApi.java</li>
    </ul>
  </li>
  <li><strong>utils/</strong>: Lógica de conversão.
    <ul>
      <li>ConversorMoeda.java</li>
    </ul>
  </li>
  <li><strong>historico/</strong>: Registro das conversões realizadas.
    <ul>
      <li>HistoricoConversao.java</li>
    </ul>
  </li>
  <li><strong>historico_conversoes.txt</strong>: Arquivo gerado com o histórico das conversões.</li>
</ul>

<h2>🛠️ Tecnologias Utilizadas</h2>
<ul>
  <li>Java 17+</li>
  <li>API HTTP nativa (<code>HttpClient</code>, <code>HttpRequest</code>, <code>HttpResponse</code>)</li>
  <li>GSON: Para desserializar o JSON da API.</li>
  <li>Manipulação de arquivos: (<code>FileWriter</code>, <code>PrintWriter</code>)</li>
  <li>Manipulação de datas: (<code>LocalDateTime</code>, <code>DateTimeFormatter</code>)</li>
</ul>

<h2>▶️ Como Usar</h2>
<ol>
  <li>Execute a aplicação em terminal ou via IDE.</li>
  <li>Escolha a moeda de origem e destino.</li>
  <li>Informe o valor a ser convertido.</li>
  <li>Veja o resultado exibido no console.</li>
  <li>O histórico da conversão será salvo automaticamente no arquivo <code>historico_conversoes.txt</code>.</li>
</ol>

<h2>✅ Funcionalidades</h2>
<h3>1. Consulta à API</h3>
<ul>
  <li>Realiza uma requisição GET para obter as taxas de câmbio atualizadas.</li>
  <li>Utiliza <code>HttpClient</code> e <code>Gson</code> para processar a resposta JSON.</li>
</ul>

<h3>2. Conversão de Moeda</h3>
<ul>
  <li>Faz o cálculo com base nas taxas da API.</li>
  <li>Usa <code>double</code> para precisão nos valores convertidos.</li>
</ul>

<h3>3. Registro de Histórico</h3>
<ul>
  <li>Cada conversão realizada é registrada em <code>historico_conversoes.txt</code> com:</li>
  <ul>
    <li>Data e hora (<code>dd/MM/yyyy HH:mm:ss</code>)</li>
    <li>Valor original, moeda de origem</li>
    <li>Valor convertido, moeda de destino</li>
  </ul>
</ul>

<h2>🔍 Funções Implementadas</h2>
<h3>1. <code>consultarTodasAsTaxas()</code></h3>
<ul>
  <li>Realiza a chamada HTTP para a API de câmbio.</li>
  <li>Retorna um objeto <code>RespostaCotacaoCompleta</code>.</li>
</ul>

<h3>2. <code>converter(String origem, String destino, double valor, Map taxas)</code></h3>
<ul>
  <li>Faz o cálculo da conversão com base nas taxas da API.</li>
  <li>Valida se a moeda existe no mapa antes de calcular.</li>
</ul>

<h3>3. <code>registrar(String origem, String destino, valor, valorConvertido)</code></h3>
<ul>
  <li>Grava a conversão no arquivo <code>historico_conversoes.txt</code>.</li>
  <li>Utiliza <code>PrintWriter</code> + <code>FileWriter</code> com <code>append = true</code>.</li>
</ul>

<h2>⚠️ Dificuldade Enfrentada</h2>
<h3>Problema com sobrescrita de arquivo</h3>
<p>Inicialmente, o arquivo de histórico sobrescrevia os dados anteriores.<br>
Para evitar isso, foi necessário utilizar o <code>FileWriter</code> no modo append:</p>

<pre><code>new FileWriter("historico_conversoes.txt", true)
</code></pre>

<p>Dessa forma, cada nova conversão é <strong>adicionada ao final</strong> do arquivo.</p>

<h2>💡 Aprendizados</h2>
<ul>
  <li>Uso prático de API HTTP nativa em Java.</li>
  <li>Manipulação segura de arquivos e fluxos com <code>try-with-resources</code>.</li>
  <li>Aplicação de boas práticas de modularização, separando responsabilidades por pacotes.</li>
  <li>Otimização de escrita em arquivo usando <code>PrintWriter</code> + <code>printf()</code> para formatação.</li>
</ul>

<h2>📄 Exemplo de Histórico</h2>
<pre><code>[29/05/2025 14:30:12] 100.00 USD → 530.00 BRL
[29/05/2025 14:45:07] 200.00 EUR → 1150.00 BRL
</code></pre>
