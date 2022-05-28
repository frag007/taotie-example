package com.frag.taotie.service.impl;

import com.frag.taotie.core.TaotieActuator;
import com.frag.taotie.dao.ReportMapper;
import com.frag.taotie.entity.DataDto;
import com.frag.taotie.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuhj
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private TaotieActuator<DataDto> dataReportProcessor;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public void report(DataDto dataDto) {
        dataReportProcessor.offer(dataDto);
    }

    @Override
    public int reportMulTable(List<DataDto> list, int queueNum) {
        int table = list.get(0).getUserId().intValue() & (queueNum - 1);
        return reportMapper.reportMulTable(list, table);
    }

}
