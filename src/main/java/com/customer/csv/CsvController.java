package com.customer.csv;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Controller
@RequestMapping("csv")
public class CsvController {
  @Autowired
  CustomerService customerService;

  @GetMapping(value = "*.csv", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
      + "; charset=Shift_JIS; Content-Disposition: attachment")
  @ResponseBody
  public Object getCsv() throws JsonProcessingException {

    List<CsvBean> csvBeans = customerService.selectIndexCsv();

    CsvMapper mapper = new CsvMapper();
    CsvSchema schema = mapper.schemaFor(CsvBean.class).withHeader();
    return mapper.writer(schema).writeValueAsString(csvBeans);
  }
}
