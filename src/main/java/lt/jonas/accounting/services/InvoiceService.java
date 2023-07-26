package lt.jonas.accounting.services;

import lombok.AllArgsConstructor;
import lt.jonas.accounting.converters.InvoiceConverter;
import lt.jonas.accounting.dto.InvoiceDTO;
import lt.jonas.accounting.entities.Invoice;
import lt.jonas.accounting.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceDTO newInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
        return InvoiceConverter.convertInvoiceToInvoiceDTO(invoice);
    }

    public InvoiceDTO getInvoiceById(Long id) {
        return InvoiceConverter.convertInvoiceToInvoiceDTO(invoiceRepository.getReferenceById(id));
    }
    public InvoiceDTO updateInvoice(Invoice invoice) {
        Invoice invoiceToUpdate = invoiceRepository.findById(invoice.getId()).orElseThrow(NoSuchElementException::new);
        invoiceToUpdate.setInvoiceNr(invoice.getInvoiceNr());
        invoiceToUpdate.setInvoiceDate(invoice.getInvoiceDate());
        return InvoiceConverter.convertInvoiceToInvoiceDTO(invoiceToUpdate);
    }
    public void deleteInvoiceById(Long id){
        invoiceRepository.deleteById(id);
    }
}
