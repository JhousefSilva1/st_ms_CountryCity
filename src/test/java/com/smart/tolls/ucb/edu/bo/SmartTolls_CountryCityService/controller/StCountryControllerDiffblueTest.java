package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCountryService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StCountryController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StCountryControllerDiffblueTest {
    @Autowired
    private StCountryController stCountryController;

    @MockBean
    private StCountryService stCountryService;

    /**
     * Test {@link StCountryController#getAllCountries()}.
     * <p>
     * Method under test: {@link StCountryController#getAllCountries()}
     */



    @Test
    @DisplayName("Test getAllCountries()")
    @Tag("MaintainedByDiffblue")
    void testGetAllCountries() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StCountryEntity>> actualAllCountries = (new StCountryController()).getAllCountries();

        // Assert
        assertEquals("", actualAllCountries.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StCountryService.isServiceAvailable()\" because \"this.stCountryService\" is null",
                actualAllCountries.getMessage());
        assertNull(actualAllCountries.getData());
        assertEquals(500, actualAllCountries.getStatus().intValue());
    }

    /**
     * Test {@link StCountryController#getAllCountriesByStatus()}.
     * <p>
     * Method under test: {@link StCountryController#getAllCountriesByStatus()}
     */
    @Test
    @DisplayName("Test getAllCountriesByStatus()")
    @Tag("MaintainedByDiffblue")
    void testGetAllCountriesByStatus() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StCountryEntity>> actualAllCountriesByStatus = (new StCountryController())
                .getAllCountriesByStatus();

        // Assert
        assertEquals("", actualAllCountriesByStatus.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StCountryService.isServiceAvailable()\" because \"this.stCountryService\" is null",
                actualAllCountriesByStatus.getMessage());
        assertNull(actualAllCountriesByStatus.getData());
        assertEquals(500, actualAllCountriesByStatus.getStatus().intValue());
    }

    /**
     * Test {@link StCountryController#getCountryById(Long)}.
     * <p>
     * Method under test: {@link StCountryController#getCountryById(Long)}
     */
    @Test
    @DisplayName("Test getCountryById(Long)")
    @Tag("MaintainedByDiffblue")
    void testGetCountryById() throws Exception {
        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity stCountryEntity = new StCountryEntity();
        stCountryEntity.setAudit(audit);
        stCountryEntity.setCountryName("GB");
        stCountryEntity.setCountryStatus(3);
        stCountryEntity.setIdCountry(1L);
        Optional<StCountryEntity> ofResult = Optional.of(stCountryEntity);
        when(stCountryService.getCountryById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/country/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stCountryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{"
                                        + "\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0"
                                        + "],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\","
                                        + "\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StCountryController#createCountry(StCountryEntity)}.
     * <p>
     * Method under test: {@link StCountryController#createCountry(StCountryEntity)}
     */
    @Test
    @DisplayName("Test createCountry(StCountryEntity)")
    @Tag("MaintainedByDiffblue")
    void testCreateCountry() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StCountryController stCountryController = new StCountryController();

        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity stCountryEntity = new StCountryEntity();
        stCountryEntity.setAudit(audit);
        stCountryEntity.setCountryName("GB");
        stCountryEntity.setCountryStatus(3);
        stCountryEntity.setIdCountry(1L);

        // Act
        ApiResponse<Optional<StCountryEntity>> actualCreateCountryResult = stCountryController
                .createCountry(stCountryEntity);

        // Assert
        assertEquals("", actualCreateCountryResult.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StCountryService.createCountry(com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity"
                        + ".StCountryEntity)\" because \"this.stCountryService\" is null",
                actualCreateCountryResult.getMessage());
        assertNull(actualCreateCountryResult.getData());
        assertEquals(400, actualCreateCountryResult.getStatus().intValue());
    }

    /**
     * Test {@link StCountryController#createCountry(StCountryEntity)}.
     * <p>
     * Method under test: {@link StCountryController#createCountry(StCountryEntity)}
     */
    @Test
    @DisplayName("Test createCountry(StCountryEntity)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testCreateCountry2() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity["audit"]->com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit["createDate"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1330)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:183)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:183)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:502)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:341)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4799)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:4040)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity stCountryEntity = new StCountryEntity();
        stCountryEntity.setAudit(audit);
        stCountryEntity.setCountryName("GB");
        stCountryEntity.setCountryStatus(3);
        stCountryEntity.setIdCountry(1L);
        String content = (new ObjectMapper()).writeValueAsString(stCountryEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/country/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(stCountryController).build().perform(requestBuilder);
    }

    /**
     * Test {@link StCountryController#updateCountry(Long, StCountryEntity)}.
     * <p>
     * Method under test: {@link StCountryController#updateCountry(Long, StCountryEntity)}
     */
    @Test
    @DisplayName("Test updateCountry(Long, StCountryEntity)")
    @Tag("MaintainedByDiffblue")
    void testUpdateCountry() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StCountryController stCountryController = new StCountryController();

        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity stCountryEntity = new StCountryEntity();
        stCountryEntity.setAudit(audit);
        stCountryEntity.setCountryName("GB");
        stCountryEntity.setCountryStatus(3);
        stCountryEntity.setIdCountry(1L);

        // Act
        ApiResponse<Optional<StCountryEntity>> actualUpdateCountryResult = stCountryController.updateCountry(1L,
                stCountryEntity);

        // Assert
        assertEquals("", actualUpdateCountryResult.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StCountryService.updateCountry(java.lang.Long, com.smart.tolls.ucb.edu.bo.SmartTolls"
                        + "_CountryCityService.entity.StCountryEntity)\" because \"this.stCountryService\" is null",
                actualUpdateCountryResult.getMessage());
        assertNull(actualUpdateCountryResult.getData());
        assertEquals(400, actualUpdateCountryResult.getStatus().intValue());
    }

    /**
     * Test {@link StCountryController#updateCountry(Long, StCountryEntity)}.
     * <p>
     * Method under test: {@link StCountryController#updateCountry(Long, StCountryEntity)}
     */
    @Test
    @DisplayName("Test updateCountry(Long, StCountryEntity)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testUpdateCountry2() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity["audit"]->com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit["createDate"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1330)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:183)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:183)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:502)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:341)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4799)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:4040)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity stCountryEntity = new StCountryEntity();
        stCountryEntity.setAudit(audit);
        stCountryEntity.setCountryName("GB");
        stCountryEntity.setCountryStatus(3);
        stCountryEntity.setIdCountry(1L);
        String content = (new ObjectMapper()).writeValueAsString(stCountryEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/country/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(stCountryController).build().perform(requestBuilder);
    }

    /**
     * Test {@link StCountryController#deleteCountry(Long)}.
     * <p>
     * Method under test: {@link StCountryController#deleteCountry(Long)}
     */
    @Test
    @DisplayName("Test deleteCountry(Long)")
    @Tag("MaintainedByDiffblue")
    void testDeleteCountry() throws Exception {
        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity stCountryEntity = new StCountryEntity();
        stCountryEntity.setAudit(audit);
        stCountryEntity.setCountryName("GB");
        stCountryEntity.setCountryStatus(3);
        stCountryEntity.setIdCountry(1L);
        Optional<StCountryEntity> ofResult = Optional.of(stCountryEntity);
        when(stCountryService.deleteCountry(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/country/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stCountryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{"
                                        + "\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0"
                                        + "],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\","
                                        + "\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }
}
