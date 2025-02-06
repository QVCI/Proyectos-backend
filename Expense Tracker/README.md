# Expense Tracker
Proyecto de Roadmap para Java Backend.
[https://roadmap.sh/projects/expense-tracker](https://roadmap.sh/projects/expense-tracker).
```bash
$ Agregar gasto:
expense-tracker add --description "Lunch" --amount 20
# Expense added successfully (ID: 1)

$ Elimina gasto:
expense-tracker delete --id 2
# Expense deleted successfully


$ Lista de gastos:
expense-tracker list
# ID  Date       Description  Amount
# 1   2024-08-06  Lunch        $20

$ Gastos totales:
expense-tracker summary
# Total expenses: $30

$ Gastos del mes:
expense-tracker summary --month 8
# Total expenses: $10
```

