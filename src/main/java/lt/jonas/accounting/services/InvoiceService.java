package lt.jonas.accounting.services;

import lombok.AllArgsConstructor;
import lt.jonas.accounting.converters.InvoiceConverter;
import lt.jonas.accounting.dto.InvoiceDTO;
import lt.jonas.accounting.entities.Invoice;
import lt.jonas.accounting.repositories.InvoiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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

    public List<InvoiceDTO> getInvoices(Pageable pageable) {
        Page<Invoice> invoices = invoiceRepository.findAll(pageable);
        return InvoiceConverter.convertInvoicePageToInvoiceDTOList(invoices);
    }

    public List<InvoiceDTO> findInvoicesByPeriod(LocalDate fromDate, LocalDate toDate) {
        return InvoiceConverter.convertInvoicesToInvoicesDTOList(invoiceRepository.findByInvoiceDateBetween(fromDate, toDate));
    }
    public void deleteInvoiceById(Long id)throws IllegalStateException {
        invoiceRepository.deleteById(id);
    }
}
