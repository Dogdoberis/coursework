package lt.jonas.accounting.controllers;


import lt.jonas.accounting.converters.InvoiceConverter;


import lt.jonas.accounting.dto.InvoiceDTO;
import lt.jonas.accounting.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<InvoiceDTO> updateInvoiceById(@RequestBody InvoiceDTO invoiceDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(invoiceService.updateInvoice(InvoiceConverter.convertInvoiceDtoToInvoice(invoiceDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoicesById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteInvoiceById(@PathVariable Long id) {
        invoiceService.deleteInvoiceById(id);
        return ResponseEntity.noContent().build();
    }
}
