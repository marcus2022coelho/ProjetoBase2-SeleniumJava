// Encontrar o elemento usando XPath
const elemento = document.evaluate("//input[@value='Entrar']", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;

// Verificar se o elemento foi encontrado
if (elemento) {
  // Clique no elemento
  elemento.click();
} else {
  console.log("Elemento não encontrado.");
}