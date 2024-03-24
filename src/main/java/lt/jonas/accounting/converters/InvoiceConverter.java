package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.InvoiceDTO;
import lt.jonas.accounting.entities.Invoice;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;

public class InvoiceConverter {
    /**
     * Converts an Invoice object to an InvoiceDTO object.
     * @param invoice The Invoice object to convert.
     * @return An InvoiceDTO object.
     */
    public static InvoiceDTO convertInvoiceToInvoiceDTO(Invoice invoice) {
        InvoiceDTO invoiceDTO = null; // Initialize a new InvoiceDTO object
        // Check if the invoice is not null
        if (invoice != null) {
            invoiceDTO = new InvoiceDTO(); // Instantiate a new InvoiceDTO object
            // Set properties of the InvoiceDTO object based on Invoice
            invoiceDTO.setId(invoice.getId());
            invoiceDTO.setInvoiceNr(invoice.getInvoiceNr());
            invoiceDTO.setInvoiceDate(invoice.getInvoiceDate());
            // Convert the associated Consumer object to ConsumerDTO
            invoiceDTO.setConsumerDTO(ConsumerConverter.convertConsumerToConsumerDTO(invoice.getConsumer()));
            // Convert the associated User object to UserDTO
            invoiceDTO.setUserDTO(UserConverter.convertUserToUserDTO(invoice.getUser()));
            // Convert the list of associated Item objects to a list of ItemDTO objects
            invoiceDTO.setItemDTOList(ItemConverter.convertItemListToItemDTOList(invoice.getItems()));
        }
        return invoiceDTO; // Return the InvoiceDTO object
    }


    /**
     * Converts an InvoiceDTO object to an Invoice object.
     * @param invoiceDTO The InvoiceDTO object to convert.
     * @return An Invoice object.
     */
    public static Invoice convertInvoiceDtoToInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = null; // Initialize a new Invoice object
        // Check if the invoiceDTO is not null
        if (invoiceDTO != null) {
            invoice = new Invoice(); // Instantiate a new Invoice object
            // Set properties of the Invoice object based on InvoiceDTO
            invoice.setId(invoiceDTO.getId());
            invoice.setInvoiceNr(invoiceDTO.getInvoiceNr());
            invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
            // Convert the associated UserDTO object to User
            invoice.setUser(UserConverter.convertUserDTOToUser(invoiceDTO.getUserDTO()));
            // Convert the associated ConsumerDTO object to Consumer
            invoice.setConsumer(ConsumerConverter.convertConsumerDtoToConsumer(invoiceDTO.getConsumerDTO()));
            // Convert the list of associated ItemDTO objects to a list of Item objects
            invoice.setItems(ItemConverter.convertItemDTOListToItemList(invoiceDTO.getItemDTOList()));
        }
        return invoice; // Return the Invoice object
    }


    /**
     * Converts a list of Invoice objects to a list of InvoiceDTO objects.
     * @param invoiceList The list of Invoice objects to convert.
     * @return A list of InvoiceDTO objects.
     */
    public static List<InvoiceDTO> convertInvoicesToInvoicesDTOList(List<Invoice> invoiceList) {
        List<InvoiceDTO> invoiceDTOList = null; // Initialize a new list of InvoiceDTO objects
        // Check if the invoiceList is not null and not empty
        if (invoiceList != null && !invoiceList.isEmpty()) {
            invoiceDTOList = new ArrayList<>(); // Initialize a new ArrayList for InvoiceDTO objects
            // Iterate through each Invoice in the invoiceList
            for (Invoice invoice : invoiceList) {
                // Convert each Invoice to an InvoiceDTO and add it to the invoiceDTOList
                invoiceDTOList.add(convertInvoiceToInvoiceDTO(invoice));
            }
        }
        return invoiceDTOList; // Return the list of InvoiceDTO objects
    }


    /**
     * Converts a Page<Invoice> object to a list of InvoiceDTO objects.
     * @param invoicesPage The Page<Invoice> object to convert.
     * @return A list of InvoiceDTO objects.
     */
    public static List<InvoiceDTO> convertInvoicePageToInvoiceDTOList(Page<Invoice> invoicesPage) {
        List<InvoiceDTO> invoiceDTOList = null; // Initialize a new list of InvoiceDTO objects
        // Check if the invoicesPage is not null and not empty
        if (invoicesPage != null && !invoicesPage.isEmpty()) {
            invoiceDTOList = new ArrayList<>(); // Initialize a new ArrayList for InvoiceDTO objects
            // Iterate through each Invoice in the invoicesPage
            for (Invoice invoice : invoicesPage) {
                // Convert each Invoice to an InvoiceDTO and add it to the invoiceDTOList
                invoiceDTOList.add(convertInvoiceToInvoiceDTO(invoice));
            }
        }
        return invoiceDTOList; // Return the list of InvoiceDTO objects
    }

}
