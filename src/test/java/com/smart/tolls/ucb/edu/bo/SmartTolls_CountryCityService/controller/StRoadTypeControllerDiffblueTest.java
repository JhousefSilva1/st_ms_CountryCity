package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StRoadTypeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StRoadTypeController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StRoadTypeControllerDiffblueTest {
    @Autowired
    private StRoadTypeController stRoadTypeController;

    @MockBean
    private StRoadTypeService stRoadTypeService;

    /**
     * Test {@link StRoadTypeController#getAllRoadTypes()}.
     * <p>
     * Method under test: {@link StRoadTypeController#getAllRoadTypes()}
     */
    @Test
    @DisplayName("Test getAllRoadTypes()")
    @Tag("MaintainedByDiffblue")
    void testGetAllRoadTypes() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StRoadTypeEntity>> actualAllRoadTypes = (new StRoadTypeController()).getAllRoadTypes();

        // Assert
        assertEquals("", actualAllRoadTypes.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StRoadTypeService.isServiceAvailable()\" because \"this.stRoadTypeService\" is null",
                actualAllRoadTypes.getMessage());
        assertNull(actualAllRoadTypes.getData());
        assertEquals(500, actualAllRoadTypes.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#getAllRoadTypesByStatus()}.
     * <p>
     * Method under test: {@link StRoadTypeController#getAllRoadTypesByStatus()}
     */
    @Test
    @DisplayName("Test getAllRoadTypesByStatus()")
    @Tag("MaintainedByDiffblue")
    void testGetAllRoadTypesByStatus() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StRoadTypeEntity>> actualAllRoadTypesByStatus = (new StRoadTypeController())
                .getAllRoadTypesByStatus();

        // Assert
        assertEquals("", actualAllRoadTypesByStatus.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StRoadTypeService.isServiceAvailable()\" because \"this.stRoadTypeService\" is null",
                actualAllRoadTypesByStatus.getMessage());
        assertNull(actualAllRoadTypesByStatus.getData());
        assertEquals(500, actualAllRoadTypesByStatus.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#getRoadTypeById(Long)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#getRoadTypeById(Long)}
     */
    @Test
    @DisplayName("Test getRoadTypeById(Long); when 'null'; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testGetRoadTypeById_whenNull_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<StRoadTypeEntity> actualRoadTypeById = (new StRoadTypeController()).getRoadTypeById(null);

        // Assert
        assertEquals("", actualRoadTypeById.getError());
        assertEquals("Invalid id", actualRoadTypeById.getMessage());
        assertNull(actualRoadTypeById.getData());
        assertEquals(400, actualRoadTypeById.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#getRoadTypeById(Long)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return Message is {@code Road type with ID: 1 not found}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#getRoadTypeById(Long)}
     */
    @Test
    @DisplayName("Test getRoadTypeById(Long); when one; then return Message is 'Road type with ID: 1 not found'")
    @Tag("MaintainedByDiffblue")
    void testGetRoadTypeById_whenOne_thenReturnMessageIsRoadTypeWithId1NotFound() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<StRoadTypeEntity> actualRoadTypeById = (new StRoadTypeController()).getRoadTypeById(1L);

        // Assert
        assertEquals("", actualRoadTypeById.getError());
        assertEquals("Road type with ID: 1 not found", actualRoadTypeById.getMessage());
        assertNull(actualRoadTypeById.getData());
        assertEquals(404, actualRoadTypeById.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#getRoadTypeById(Long)}.
     * <ul>
     *   <li>When zero.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#getRoadTypeById(Long)}
     */
    @Test
    @DisplayName("Test getRoadTypeById(Long); when zero; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testGetRoadTypeById_whenZero_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<StRoadTypeEntity> actualRoadTypeById = (new StRoadTypeController()).getRoadTypeById(0L);

        // Assert
        assertEquals("", actualRoadTypeById.getError());
        assertEquals("Invalid id", actualRoadTypeById.getMessage());
        assertNull(actualRoadTypeById.getData());
        assertEquals(400, actualRoadTypeById.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}.
     * <p>
     * Method under test: {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test createRoadType(StRoadTypeEntity)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testCreateRoadType() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity["audit"]->com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit["createDate"])
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

        StRoadTypeEntity stRoadTypeEntity = new StRoadTypeEntity();
        stRoadTypeEntity.setAudit(audit);
        stRoadTypeEntity.setIdRoadType(1L);
        stRoadTypeEntity.setRoadType("Road Type");
        stRoadTypeEntity.setRoadTypeStatus(1);
        String content = (new ObjectMapper()).writeValueAsString(stRoadTypeEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/roadType/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(stRoadTypeController).build().perform(requestBuilder);
    }

    /**
     * Test {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}.
     * <ul>
     *   <li>Given empty string.</li>
     *   <li>When {@link StRoadTypeEntity#StRoadTypeEntity()} RoadType is empty string.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test createRoadType(StRoadTypeEntity); given empty string; when StRoadTypeEntity() RoadType is empty string")
    @Tag("MaintainedByDiffblue")
    void testCreateRoadType_givenEmptyString_whenStRoadTypeEntityRoadTypeIsEmptyString() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType("");

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualCreateRoadTypeResult = stRoadTypeController.createRoadType(roadType);

        // Assert
        assertEquals("", actualCreateRoadTypeResult.getError());
        assertEquals("Road type is required", actualCreateRoadTypeResult.getMessage());
        assertNull(actualCreateRoadTypeResult.getData());
        assertEquals(400, actualCreateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     *   <li>When {@link StRoadTypeEntity#StRoadTypeEntity()} RoadType is {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test createRoadType(StRoadTypeEntity); given 'null'; when StRoadTypeEntity() RoadType is 'null'")
    @Tag("MaintainedByDiffblue")
    void testCreateRoadType_givenNull_whenStRoadTypeEntityRoadTypeIsNull() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType(null);

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualCreateRoadTypeResult = stRoadTypeController.createRoadType(roadType);

        // Assert
        assertEquals("", actualCreateRoadTypeResult.getError());
        assertEquals("Road type is required", actualCreateRoadTypeResult.getMessage());
        assertNull(actualCreateRoadTypeResult.getData());
        assertEquals(400, actualCreateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code Road Type}.</li>
     *   <li>Then return Message is a string.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test createRoadType(StRoadTypeEntity); given 'Road Type'; then return Message is a string")
    @Tag("MaintainedByDiffblue")
    void testCreateRoadType_givenRoadType_thenReturnMessageIsAString() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadType("Road Type");
        roadType.setRoadTypeStatus(1);

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualCreateRoadTypeResult = stRoadTypeController.createRoadType(roadType);

        // Assert
        assertEquals("", actualCreateRoadTypeResult.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StRoadTypeService.createRoadType(com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".entity.StRoadTypeEntity)\" because \"this.stRoadTypeService\" is null",
                actualCreateRoadTypeResult.getMessage());
        assertNull(actualCreateRoadTypeResult.getData());
        assertEquals(400, actualCreateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code Road Type}.</li>
     *   <li>Then return Message is a string.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#createRoadType(StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test createRoadType(StRoadTypeEntity); given 'Road Type'; then return Message is a string")
    @Tag("MaintainedByDiffblue")
    void testCreateRoadType_givenRoadType_thenReturnMessageIsAString2() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType("Road Type");

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualCreateRoadTypeResult = stRoadTypeController.createRoadType(roadType);

        // Assert
        assertEquals("", actualCreateRoadTypeResult.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StRoadTypeService.createRoadType(com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".entity.StRoadTypeEntity)\" because \"this.stRoadTypeService\" is null",
                actualCreateRoadTypeResult.getMessage());
        assertNull(actualCreateRoadTypeResult.getData());
        assertEquals(400, actualCreateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity["audit"]->com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit["createDate"])
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

        StRoadTypeEntity stRoadTypeEntity = new StRoadTypeEntity();
        stRoadTypeEntity.setAudit(audit);
        stRoadTypeEntity.setIdRoadType(1L);
        stRoadTypeEntity.setRoadType("Road Type");
        stRoadTypeEntity.setRoadTypeStatus(1);
        String content = (new ObjectMapper()).writeValueAsString(stRoadTypeEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/roadType/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(stRoadTypeController).build().perform(requestBuilder);
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given empty string.</li>
     *   <li>Then return Message is {@code Road type is required}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given empty string; then return Message is 'Road type is required'")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenEmptyString_thenReturnMessageIsRoadTypeIsRequired() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType("");

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(1L,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals("Road type is required", actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given empty string.</li>
     *   <li>When {@code null}.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given empty string; when 'null'; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenEmptyString_whenNull_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType("");

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(null,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals("Invalid id", actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given empty string.</li>
     *   <li>When zero.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given empty string; when zero; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenEmptyString_whenZero_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType("");

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(0L,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals("Invalid id", actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     *   <li>Then return Message is {@code Road type is required}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given 'null'; then return Message is 'Road type is required'")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenNull_thenReturnMessageIsRoadTypeIsRequired() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType(null);

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(1L,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals("Road type is required", actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     *   <li>When {@code null}.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given 'null'; when 'null'; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenNull_whenNull_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType(null);

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(null,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals("Invalid id", actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     *   <li>When zero.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given 'null'; when zero; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenNull_whenZero_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType(null);

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(0L,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals("Invalid id", actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code Road Type}.</li>
     *   <li>When {@code null}.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given 'Road Type'; when 'null'; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenRoadType_whenNull_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType("Road Type");

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(null,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals("Invalid id", actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code Road Type}.</li>
     *   <li>When one.</li>
     *   <li>Then return Message is a string.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given 'Road Type'; when one; then return Message is a string")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenRoadType_whenOne_thenReturnMessageIsAString() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadType("Road Type");
        roadType.setRoadTypeStatus(1);

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(1L,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StRoadTypeService.updateRoadType(java.lang.Long, com.smart.tolls.ucb.edu.bo.SmartTolls"
                        + "_CountryCityService.entity.StRoadTypeEntity)\" because \"this.stRoadTypeService\" is null",
                actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code Road Type}.</li>
     *   <li>When one.</li>
     *   <li>Then return Message is a string.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given 'Road Type'; when one; then return Message is a string")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenRoadType_whenOne_thenReturnMessageIsAString2() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType("Road Type");

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(1L,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StRoadTypeService.updateRoadType(java.lang.Long, com.smart.tolls.ucb.edu.bo.SmartTolls"
                        + "_CountryCityService.entity.StRoadTypeEntity)\" because \"this.stRoadTypeService\" is null",
                actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}.
     * <ul>
     *   <li>Given {@code Road Type}.</li>
     *   <li>When zero.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StRoadTypeController#updateRoadType(Long, StRoadTypeEntity)}
     */
    @Test
    @DisplayName("Test updateRoadType(Long, StRoadTypeEntity); given 'Road Type'; when zero; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testUpdateRoadType_givenRoadType_whenZero_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StRoadTypeController stRoadTypeController = new StRoadTypeController();

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

        StRoadTypeEntity roadType = new StRoadTypeEntity();
        roadType.setAudit(audit);
        roadType.setIdRoadType(1L);
        roadType.setRoadTypeStatus(1);
        roadType.setRoadType("Road Type");

        // Act
        ApiResponse<Optional<StRoadTypeEntity>> actualUpdateRoadTypeResult = stRoadTypeController.updateRoadType(0L,
                roadType);

        // Assert
        assertEquals("", actualUpdateRoadTypeResult.getError());
        assertEquals("Invalid id", actualUpdateRoadTypeResult.getMessage());
        assertNull(actualUpdateRoadTypeResult.getData());
        assertEquals(400, actualUpdateRoadTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StRoadTypeController#deleteRoadType(Long)}.
     * <p>
     * Method under test: {@link StRoadTypeController#deleteRoadType(Long)}
     */
    @Test
    @DisplayName("Test deleteRoadType(Long)")
    @Tag("MaintainedByDiffblue")
    void testDeleteRoadType() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<Optional<StRoadTypeEntity>> actualDeleteRoadTypeResult = (new StRoadTypeController())
                .deleteRoadType(1L);

        // Assert
        assertEquals("", actualDeleteRoadTypeResult.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StRoadTypeService.deleteRoadType(java.lang.Long)\" because \"this.stRoadTypeService\" is"
                        + " null",
                actualDeleteRoadTypeResult.getMessage());
        assertNull(actualDeleteRoadTypeResult.getData());
        assertEquals(400, actualDeleteRoadTypeResult.getStatus().intValue());
    }
}
