package com.ra.base_spring_mvc.controller.user;

import com.ra.base_spring_mvc.model.entity.Voucher;
import com.ra.base_spring_mvc.model.service.voucher.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userVoucher")
public class UserVoucherController {
    @Autowired
    private VoucherService voucherService;
    @GetMapping
    public String getVoucher(Model model){
        List<Voucher> vouchers = voucherService.getListVoucher();
        model.addAttribute("vouchers",vouchers);
        return "user/getVoucher";
    }
}
