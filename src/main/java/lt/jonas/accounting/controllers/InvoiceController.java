package lt.jonas.accounting.controllers;


import lt.jonas.accounting.converters.InvoiceConverter;
import lt.jonas.accounting.dto.InvoiceDTO;
import lt.jonas.accounting.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceDTO> writeNewInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED).body(invoiceService.newInvoice(InvoiceConverter.convertInvoiceDtoToInvoice(invoiceDTO)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InvoiceDTO> updateInvoiceById(@RequestBody InvoiceDTO invoiceDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(invoiceService.updateInvoice(InvoiceConverter.convertInvoiceDtoToInvoice(invoiceDTO)));
    }
    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(invoiceService.getInvoices(pageable));
    }
    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceDTO>> getIvoicesByPeriod(@RequestParam("fromDate") String fromDateS, @RequestParam("toDate") String toDateS){
        LocalDate fromDate = LocalDate.parse(fromDateS);
        LocalDate toDade = LocalDate.parse(toDateS);
        return ResponseEntity.ok(invoiceService.findInvoicesByPeriod(fromDate, toDade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoicesById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteInvoiceById(@PathVariable Long id) {
        invoiceService.deleteInvoiceById(id);
        return ResponseEntity.noContent().build();
    }
}
