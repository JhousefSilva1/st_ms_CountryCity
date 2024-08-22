package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StTicketRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StTicketService {

    @Autowired
    private StTicketRepository stTicketRepository;

    public List<StTicketEntity> getAllTickets() {
        return stTicketRepository.findAll();
    }

    public Optional<StTicketEntity> getTicketById(int id) {
        return stTicketRepository.findById((long) id);
    }

    public StTicketEntity createTicket(StTicketEntity ticket) {
        return stTicketRepository.save(ticket);
    }

    public Optional<StTicketEntity> updateTicket(int id, StTicketEntity ticketDetails) {
        StTicketEntity ticket = stTicketRepository.findById((long) id).

                orElseThrow(() -> new RuntimeException("Ticket not found"));
//        ticket.setStTicketId(ticketDetails.getStTicketId());
//        ticket.setStTicketName(ticketDetails.getStTicketName());
        // Update other fields as needed
        return Optional.of(stTicketRepository.save(ticket));
    }

    public void deleteTicket(int id) {
        stTicketRepository.deleteById((long) id);
    }

}
