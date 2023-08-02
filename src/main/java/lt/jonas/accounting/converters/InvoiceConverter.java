package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.InvoiceDTO;
import lt.jonas.accounting.dto.ItemDTO;
import lt.jonas.accounting.entities.Invoice;
import lt.jonas.accounting.entities.Item;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceConverter {
    public static InvoiceDTO convertInvoiceToInvoiceDTO(Invoice invoice) {
        InvoiceDTO invoiceDTO = null;
        if (invoice != null) {
            invoiceDTO = new InvoiceDTO();
            invoiceDTO.setId(invoice.getId());
            invoiceDTO.setInvoiceNr(invoice.getInvoiceNr());
            invoiceDTO.setInvoiceDate(invoice.getInvoiceDate());

        }
        return invoiceDTO;
    }

    public static Invoice convertInvoiceDtoToInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = null;
        if (invoiceDTO != null) {
            invoice = new Invoice();
            invoice.setId(invoiceDTO.getId());
            invoice.setInvoiceNr(invoiceDTO.getInvoiceNr());
            invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        }
        return invoice;
    }

    public static List<InvoiceDTO> convertInvoicesToInvoicesDTOList(List<Invoice> invoiceList) {
        List<InvoiceDTO> invoiceDTOList = null;
        if (invoiceList != null && !invoiceList.isEmpty()) {
            invoiceDTOList = new ArrayList<>();
            for (Invoice a : invoiceList) {
                invoiceDTOList.add(convertInvoiceToInvoiceDTO(a));
            }
        }
        return invoiceDTOList;
    }
    public static List<InvoiceDTO> convertInvoicePageToInvoiceDTOList(Page<Invoice> invoicesPage){
        List<InvoiceDTO> invoiceDTOList = null;
        if (invoicesPage != null && !invoicesPage.isEmpty()){
            invoiceDTOList = new ArrayList<>();
            for (Invoice i : invoicesPage) {
                invoiceDTOList.add(convertInvoiceToInvoiceDTO(i));
            }
        }return invoiceDTOList;
    }
}
