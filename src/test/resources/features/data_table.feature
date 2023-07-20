Feature: DataTable

  @dataType
  Scenario: single row with no header
    Given minhas credenciais
      | marcus  | marcus123  |
      | flavia  | flavia123  |
      | murillo | murillo123 |

  @MultipleRowWithHeader
  Scenario: Multiple row with header
    Given minhas credenciais com multiple row and header
      | username | password   |
      | marcus   | marcus123  |
      | flavia   | flavia123  |
      | murillo  | murillo123 |


  Scenario: Multiple row with header TadatableType
    Given minhas credenciais com multiple row and header - TadatableType
      | username | password   |
      | marcus   | marcus123  |
      | flavia   | flavia123  |
      | murillo  | murillo123 |