import React from "react";
import MaterialTable from "material-table";
import styled from "styled-components";
import { Button } from "@material-ui/core";
import { config } from "../config";

export const CustomTable = (props) => {
  const columns = [
    { title: "Id", field: "id" },
    { title: "Sender", field: "sender", sorting: false },
    { title: "Receiver", field: "receiver", sorting: false },
    {
      title: "Total Amount",
      field: "totalAmount",
      sorting: false,
    },
    {
      title: "Total Amount Paid",
      field: "totalAmountPaid",
      sorting: false,
      render: (row) => (
        <Button onClick={() => props.history.push(`/installments/${row.id}`)}>
          {row.totalPaidAmount}
        </Button>
      ),
    },
  ];

  return (
    <TableContainer>
      <MaterialTable
        title="Transaction Data"
        columns={columns}
        options={{
          sorting: true,
          debounceInterval: 700,
          padding: "dense",
          filtering: false,
          search: false,
          pageSizeOptions: 2,
          pageSize: 2,
          // paginationType: "stepped",
        }}
        data={(query) =>
          new Promise((resolve, reject) => {
            // prepare your data and then call resolve like this:
            let url = `${config.backendBaseUrl}transaction?`;

            //searching
            if (query.search) {
              url += `q=${query.search}`;
            }
            //sorting
            if (query.orderBy) {
              url += `&sort=${query.orderBy.field},${query.orderDirection}`;
            }
            //filtering
            if (query.filters.length) {
              const filter = query.filters.map((filter) => {
                return `&${filter.column.field}${filter.operator}${filter.value}`;
              });
              url += filter.join("");
            }
            //pagination
            url += `&page=${query.page + 1}`;
            url += `&size=${query.pageSize}`;

            fetch(url)
              .then((resp) => resp.json())
              .then((resp) => {
                resolve({
                  data: resp.content, // your data array
                  page: query.page, // current page number
                  totalCount: resp.totalElements, // total row number
                });
              });
          })
        }
      />
    </TableContainer>
  );
};

const TableContainer = styled.div`
  margin-top: 15vh;
  max-height: 70vh;
  overflow-y: scroll;
`;
