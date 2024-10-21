package com.ra.base_spring_mvc.model.service.voucher;

import com.ra.base_spring_mvc.model.dao.voucher.VoucherDAO;
import com.ra.base_spring_mvc.model.entity.Voucher;
import com.ra.base_spring_mvc.model.entity.dto.VoucherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class VoucherServiceImpl implements VoucherService{
    @Autowired
    private VoucherDAO voucherDAO;
    @Override
    public List<Voucher> getListVoucher() {
        return voucherDAO.getListVoucher();
    }

    @Override
    public boolean addVoucher(Voucher voucher) {
        if(checkValidStartDate(voucher.getStart_date())){
            if(checkValidEndDate(voucher.getStart_date(),voucher.getEnd_date())){
                return voucherDAO.addVoucher(voucher);
            }else {
                return false;
            }
        }else {
            return false ;
        }

    }

    @Override
    public boolean updateVoucher(Voucher voucher) {
        if(checkValidStartDate(voucher.getStart_date())){
            if(checkValidEndDate(voucher.getStart_date(),voucher.getEnd_date())){
                return voucherDAO.updateVoucher(voucher);
            }else {
                return false;
            }
        }else {
            return false ;
        }
    }

    @Override
    public boolean deleteVoucher(Voucher voucher) {
        return voucherDAO.deleteVoucher(voucher);
    }

    @Override
    public Voucher findById(int id) {
        return voucherDAO.findById(id);
    }

    @Override
    public List<Voucher> getListPagination(int page, int size) {
        return voucherDAO.getListPagination(page, size);
    }

    @Override
    public Voucher converseVoucherDto(VoucherDto voucherDto) {
        Voucher voucher = new Voucher();
        voucher.setCode(voucherDto.getCode());
        voucher.setPersent(voucherDto.getPersent());
        voucher.setQuantity(voucherDto.getQuantity());
        voucher.setMin_amount(voucherDto.getMin_amount());
        voucher.setStart_date(voucherDto.getStart_date());
        voucher.setEnd_date(voucherDto.getEnd_date());
        return voucher;
    }

    @Override
    public VoucherDto converseVoucher(Voucher voucher) {
        VoucherDto voucherDto = new VoucherDto();
        voucherDto.setCode(voucher.getCode());
        voucherDto.setPersent(voucher.getPersent());
        voucherDto.setQuantity(voucher.getQuantity());
        voucherDto.setMin_amount(voucher.getMin_amount());
        voucherDto.setStart_date(voucher.getStart_date());
        voucherDto.setEnd_date(voucher.getEnd_date());
        return voucherDto;
    }

    @Override
    public boolean CheckCodeExist(String _code) {
        List<Voucher> vouchers = getListVoucher();
        return vouchers.stream().map(Voucher::getCode).anyMatch(code -> code.equals(_code));
    }

    @Override
    public boolean checkValidStartDate(Date startDate) {
        Date currentDate = new Date();
        return !startDate.after(currentDate);
    }

    @Override
    public boolean checkValidEndDate(Date start_date, Date end_date) {
        return end_date.after(start_date);
    }

//    public static void main(String[] args) {
//        Voucher voucher = new Voucher(2,"huongcaoha123",15,50000,1000,new Date(),new Date("2024-10-19"));
//        VoucherServiceImpl voucherService = new VoucherServiceImpl();
//        voucherService.addVoucher(voucher);
//    }
}
