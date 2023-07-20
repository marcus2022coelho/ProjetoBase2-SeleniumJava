package projetoBase2.stepdefinitions;

//public class MyStepdefsDataTable {


//    @DataTableType
//    public Cliente cliente (List<String> entrada){
//        return new Cliente(entrada.get(0), entrada.get(1));
//    }


//    @Given("minhas credenciais")
//    public void minhasCredenciais(List<Cliente> cliente) {
//
//        //List<List<String>> list =  dataTable.asLists();
//        System.out.println(cliente.get(0).getUsername());
//        System.out.println(cliente.get(0).getPassword());
//        System.out.println(cliente.get(1).getUsername());
//        System.out.println(cliente.get(1).getPassword());
//        System.out.println(cliente.get(2).getUsername());
//        System.out.println(cliente.get(2).getPassword());

//        System.out.println("username = "+ list.get(0).get(0));
//        System.out.println("password = "+ list.get(0).get(1));
//        System.out.println("username = "+ list.get(1).get(0));
//        System.out.println("password = "+ list.get(1).get(1));
//        System.out.println("username = "+ list.get(2).get(0));
//        System.out.println("password = "+ list.get(2).get(1));
   // }

//    @Given("minhas credenciais com multiple row and header")
//    public void minhasCredenciaisComMultipleRowAndHeader(List<Map<String,String>> teste) {
//        System.out.println(teste.get(0).get("username"));
//        System.out.println(teste.get(0).get("password"));
//        System.out.println(teste.get(1).get("username"));
//        System.out.println(teste.get(1).get("password"));
//        System.out.println(teste.get(2).get("username"));
//        System.out.println(teste.get(2).get("password"));
//    }


    // Nesse caso, vamos precisar utilizar o MAP no datatabletype e lá na step, converter para lista de lista, uma vez que
    // o datatabletype NÃO aceita lista de lista.

//    @DataTableType
//    public Cliente cliente (Map<String, String>   entrada){
//        return new Cliente(entrada.get("username"), entrada.get("password"));
//    }
//
//    @Given("minhas credenciais com multiple row and header - TadatableType")
//    public void minhasCredenciaisComMultipleRowAndHeaderTadatableType(List<Cliente> clientes) {
//        System.out.println(clientes.get(0).getUsername());
//        System.out.println(clientes.get(0).getPassword());
//        System.out.println(clientes.get(1).getUsername());
//        System.out.println(clientes.get(1).getPassword());
//        System.out.println(clientes.get(2).getUsername());
//        System.out.println(clientes.get(2).getPassword());
//    }


    //Froma alternativa criando uma lista para cada linha da tabela - famosa gambis
//    @Given("minhas credenciais")
//    public void minhasCredenciais(DataTable dataTable){
//        List<String> creds = dataTable.row(0);
//        List<String> creds1 = dataTable.row(1);
//        System.out.println(creds.get(0));
//        System.out.println(creds.get(1));
//        System.out.println(creds1.get(0));
//        System.out.println(creds1.get(1));
//    }

    // Para não fazer o exemplo acima, criando várias listas, podemos utilizar outra função do dataTable, o .asLists()
    // Dessa forma, não precisamos mais usar várias listas, e sim, lista de lista. O valor zero da lista, tera o valor 0 e 1
    // Da mesma forma a posicao 2 da lista, terá os valores da coluna 0 e da coluna 1.

//    @Given("minhas credenciais")
//    public void minhasCredenciais(DataTable dataTable) {
//        List<List<String>> lista = dataTable.asLists();   //Lista de lista, mudando o inicio e o método final
//        System.out.println(lista.get(0).get(0));
//        System.out.println(lista.get(0).get(1));
//        System.out.println(lista.get(1).get(0));
//        System.out.println(lista.get(1).get(1));
//        System.out.println(lista.get(2).get(0));
//        System.out.println(lista.get(2).get(1));
//
//    }

