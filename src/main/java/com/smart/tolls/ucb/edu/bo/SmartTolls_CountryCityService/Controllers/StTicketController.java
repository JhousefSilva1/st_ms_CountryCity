package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StTicketService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class StTicketController {

    @Autowired
    private StTicketService stTicketService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StTicketEntity> getAllTickets() {
        return stTicketService.getAllTickets();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StTicketEntity> getTicketById(@PathVariable int id) {
        return ResponseEntity.of(stTicketService.getTicketById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StTicketEntity createTicket(@RequestBody StTicketEntity ticket) {
        return stTicketService.createTicket(ticket);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StTicketEntity> updateTicket(@PathVariable int id, @RequestBody StTicketEntity ticketDetails) {
        return ResponseEntity.of(stTicketService.updateTicket(id, ticketDetails));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable int id) {
        stTicketService.deleteTicket(id);
    }
}
