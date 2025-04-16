package org.example.helthfirstchannelingcenter.controller;

import jakarta.validation.Valid;
import org.example.helthfirstchannelingcenter.dto.BookAppoinmentDTO;
import org.example.helthfirstchannelingcenter.dto.ResponseDTO;
import org.example.helthfirstchannelingcenter.service.BookAppoinmentService;
import org.example.helthfirstchannelingcenter.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/bookappoinment")
@CrossOrigin(origins = "http://localhost:63342/")
public class BookAppoinmentController {


    private final BookAppoinmentService bookAppoinmentService;

    public BookAppoinmentController(BookAppoinmentService bookAppoinmentService) {
        this.bookAppoinmentService = bookAppoinmentService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("saveAppoinments")
   public ResponseEntity<ResponseDTO> saveAppoinments(@Valid @RequestBody BookAppoinmentDTO bookAppoinmentDTO) {
        System.out.println(bookAppoinmentDTO);
       try{
           int res = bookAppoinmentService.saveAppoinments(bookAppoinmentDTO);
           switch (res){
               case VarList.Created -> {
                   return ResponseEntity.status(HttpStatus.CREATED)
                           .body(new ResponseDTO(VarList.Created, "Success", bookAppoinmentDTO));
               }
               default -> {
                   return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                           .body(new ResponseDTO(VarList.Bad_Gateway, "Error", bookAppoinmentDTO));
               }
           }
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), bookAppoinmentDTO));
       }
       }



    @GetMapping("/getallAppointments")
    public ResponseEntity<List<BookAppoinmentDTO>> getAllAppointments() {
        return ResponseEntity.ok(bookAppoinmentService.getAllAppointments());
    }


    @DeleteMapping("/cancel/{appId}")
        public ResponseEntity<ResponseDTO> deleteAppoinment(@PathVariable UUID appId) {
            try {
                int res = bookAppoinmentService.deleteAppoinment(appId);
                switch (res) {
                    case VarList.OK -> {
                        return ResponseEntity.status(HttpStatus.OK)
                                .body(new ResponseDTO(VarList.OK, "Success", null));
                    }
                    default -> {
                        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                    }
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
            }
    }
}
