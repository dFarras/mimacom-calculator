package mimacom.calculator.controller;

import mimacom.calculator.CalculatorApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CalculatorApp.class
)
public class CalculatorControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void additionOfTwoIntegersShouldResultIn200OKWithProperResult() throws Exception {
        MvcResult result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/calculate")
                        .param("operation", "5+4")
        ).andExpect(
                status().isOk()
        ).andReturn();

        String additionResult = result.getResponse().getContentAsString();

        Assertions.assertEquals("9", additionResult);
    }

    @Test
    public void additionOfDecimalsSHouldResultIn200OKWithProperResult() throws Exception {
        MvcResult result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/calculate")
                        .param("operation", "5.2+4")
        ).andExpect(
                status().isOk()
        ).andReturn();

        String additionResult = result.getResponse().getContentAsString();

        Assertions.assertEquals("9.2", additionResult);
    }

    @Test
    public void subtractionOfTwoIntegersResultIn200OKWithProperResult() throws Exception {
        MvcResult result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/calculate")
                        .param("operation", "5-4")
        ).andExpect(
                status().isOk()
        ).andReturn();

        String additionResult = result.getResponse().getContentAsString();

        Assertions.assertEquals("1", additionResult);
    }

    @Test
    public void subtractionOfTwoDecimalsResultIn200OKWithProperResult() throws Exception {
        MvcResult result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/calculate")
                        .param("operation", "5.2-4")
        ).andExpect(
                status().isOk()
        ).andReturn();

        String additionResult = result.getResponse().getContentAsString();

        Assertions.assertEquals("1.2", additionResult);
    }

    @Test
    @Disabled("Until operation validator is created")
    public void attemptingAnOperationWhereAnyOperandIsNotANumberShouldReturnA400BadRequest() throws Exception {
    }

}
