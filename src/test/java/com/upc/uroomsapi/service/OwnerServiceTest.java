//package com.upc.uroomsapi.service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Fail.fail;
//
//@SpringBootTest
//public class OwnerServiceTest {
//    @Autowired
//    private WorkspaceService service;
//
//    @Test
//    @Transactional
//    public void testListWorkspaces() {
//        WorkspacePage workspaces = service.getAll(
//                0,
//                10,
//                "workspaceId",
//                true
//        );
//
//        assertThat(workspaces.getContent()).size().isGreaterThan(0);
//    }
//
//    @Test
//    @Transactional
//    public void testGetWorkspaceById() {
//        long id = 10;
//        WorkspaceDto workspaceDto = null;
//
//        try {
//            workspaceDto = service.getWorkspaceById(id);
//        } catch (ResourceNotFoundException ex) {
//            fail(ex.getMessage());
//        }
//
//        assertThat(workspaceDto).isNotEqualTo(null);
//    }
//}
