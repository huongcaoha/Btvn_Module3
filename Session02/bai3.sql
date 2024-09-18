create database session2_bai3 ;

create table VatTu (
maVT int auto_increment primary key ,
tenVT varchar(255) not null  
);

create table PhieuXuat (
soPX int auto_increment primary key ,
ngayXuat datetime default current_timestamp
);

create table PhieuXuatChiTiet (
soPX int not null references PhieuXuat(soPx),
maVT int not null references VatTu(maVT),
donGiaXuat double not null ,
soLuongXuat int not null 
);

create table PhieuNhap(
soPN int auto_increment primary key ,
ngayNhap datetime default current_timestamp 
);

create table PhieuNhapChiTiet(
soPN int not null references PhieuNhap(soPn),
maVT int not null references VatTu(maVt),
donGiaNhap double not null,
soLuongNhap int not null
);

create table NhaCungCap(
maNCC int auto_increment primary key ,
tenNCC varchar(255) not null ,
diachi varchar(255) not null ,
soDienThoai varchar(11) not null
);

create table DonDatHang(
soDH int auto_increment primary key ,
maNCC int not null references NhaCungCap(maNCC),
ngayDH datetime default current_timestamp 
);

create table ChiTietDonHang (
maVt int not null references VatTu(maVT),
soHD int not null references DonDatHang(soDH)
);