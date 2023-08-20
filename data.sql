	USE doan_trasua;

INSERT INTO Account VALUES('ACC1','taduyhoang872002@gmail.com','$2a$10$Q0lwvrkcXsUkihqtYvUWu.bBh7qFhTbpI4G0j4SRlmtmW.zuQ/YFW'
	,'2023-04-26 04:40:20',null, null,"CUSTOMER", N'Hoàng Văn Nam', '0976543213', N'44 Trương Văn Thành', true);
INSERT INTO Account VALUES('ACC2','thanhnb@gmail.com','$2a$10$Q0lwvrkcXsUkihqtYvUWu.bBh7qFhTbpI4G0j4SRlmtmW.zuQ/YFW'
	,'2023-04-26 04:40:20',null, null,"ADMIN" , N'Nguyễn Bá Thanh', '0761238902', N'77 Lê Thánh Tông', true);
INSERT INTO Account VALUES('ACC3','hoangtd@gmail.com','$2a$10$Q0lwvrkcXsUkihqtYvUWu.bBh7qFhTbpI4G0j4SRlmtmW.zuQ/YFW'
	,'2023-04-26 04:40:20',null, null,"STAFF_MANAGER" , N'Tạ Duy Hoàng', '0798238902', N'32 Trần Đại Nghĩa', true);
INSERT INTO Account VALUES('ACC4','namna@gmail.com','$2a$10$Q0lwvrkcXsUkihqtYvUWu.bBh7qFhTbpI4G0j4SRlmtmW.zuQ/YFW'
	,'2023-04-26 04:40:20',null, null,"SHIPPER" , N'Nguyễn Nam Anh', '0135679265', N'152 Ngô Quyền', true);
INSERT INTO Account VALUES('ACC5','20110560@student.hcmute.edu.vn','$2a$10$Q0lwvrkcXsUkihqtYvUWu.bBh7qFhTbpI4G0j4SRlmtmW.zuQ/YFW'
	,'2023-04-26 04:40:20',null, null,"STAFF_MANAGER" , N'Phan Hồng Sơn', '0804066991', N'33 Bình Chánh', true);
INSERT INTO Account VALUES('ACC6','caohv@gmail.com','$2a$10$Q0lwvrkcXsUkihqtYvUWu.bBh7qFhTbpI4G0j4SRlmtmW.zuQ/YFW'
	,'2023-04-26 04:40:20',null, null,"CUSTOMER" , N'Hoàng Văn Cao', '0556447998', N'28 Lê Văn Việt', true);

INSERT INTO ingredient VALUES('IGD1', N'Lục trà', '2023-05-01', '2024-05-01', 400000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD2', N'Hồng trà', '2023-05-01', '2024-05-01', 450000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD3', N'Trà ô long', '2023-05-01', '2024-05-01', 520000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD4', N'Trà lài', '2023-05-01', '2024-05-01', 400000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD5', N'Trà bí đao', '2023-05-01', '2024-05-01', 480000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD6', N'Trà xanh', '2023-05-01', '2024-05-01', 490000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD7', N'Trà gạo', '2023-05-01', '2024-05-01', 430000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD8', N'Trà hoa', '2023-05-01', '2024-05-01', 350000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD9', N'Sữa bột Vinamilk', '2023-05-01', '2024-05-01', 4800000, 8000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
INSERT INTO ingredient VALUES('IGD10', N'Đào', '2023-05-01', '2024-05-01', 180000, 3000, '2023-05-01 12:35:40'
	, null, 'ACC5', true);
INSERT INTO ingredient VALUES('IGD11', N'Bạc hà', '2023-05-01', '2024-05-01', 120000, 4000, '2023-05-01 12:35:40'
	, null, 'ACC5', true);
INSERT INTO ingredient VALUES('IGD12', N'Hạnh nhân', '2023-05-01', '2024-05-01', 600000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC5', true);
INSERT INTO ingredient VALUES('IGD13', N'Sô cô la', '2023-05-01', '2024-05-01', 750000, 1000, '2023-05-01 12:35:40'
	, null, 'ACC5', true);
INSERT INTO ingredient VALUES('IGD14', N'Trân châu', '2023-05-01', '2024-05-01', 630000, 5000, '2023-05-01 12:35:40'
	, null, 'ACC3', true);
    
INSERT INTO Salary VALUES('SA1', 'STAFF_MANAGER', 30000, false, true);
INSERT INTO Salary VALUES('SA2', 'STAFF_MANAGER', 40000, true, true);
INSERT INTO Salary VALUES('SA3', 'SHIPPER', 16000, false, true);
INSERT INTO Salary VALUES('SA4', 'SHIPPER', 23000, true, true);
INSERT INTO Salary VALUES('SA5', 'STAFF', 20000, false, true);
INSERT INTO Salary VALUES('SA6', 'STAFF', 25000, true, true);
 
    
INSERT INTO Staff VALUES('789123678352', N'Tạ Duy Hoàng', '0798238902', N'32 Trần Đại Nghĩa', 'hoangtd@gmail.com', 'STAFF_MANAGER'
	, '2002-04-05', '2023-04-26', 'SA1', 'SA2', null, 'ACC3', null, true);
INSERT INTO Staff VALUES('872515267382', N'Nguyễn Nam Anh', '0135679265', N'152 Ngô Quyền', 'namna@gmail.com', 'SHIPPER'
	, '2000-07-20', '2023-04-26', 'SA3', 'SA4', '789123678352', null, 'ACC4', true);
INSERT INTO Staff VALUES('952357362740', N'Phan Thành Đạt', '0903067077', N'152 Cao Lãnh', 'datpt@gmail.com', 'STAFF'
	, '2000-07-13', '2023-04-26', 'SA5', 'SA6', '789123678352', null, null, true);
INSERT INTO Staff VALUES('826167293461', N'Phan Tấn Lộc', '0403448997', N'33 An Sương', 'locpt@gmail.com', 'STAFF'
	, '2000-05-23', '2023-04-26', 'SA5', 'SA6', '789123678352', null, null, true);
INSERT INTO Staff VALUES('017363618581', N'Phan Hồng Sơn', '0804066991', N'33 Bình Chánh', '20110560@student.hcmute.edu.vn', 'STAFF_MANAGER'
	, '2002-04-23', '2023-04-26', 'SA1', 'SA2', null, 'ACC5', null, true);
INSERT INTO Staff VALUES('789712346656', N'Phan Tấn Nghĩa', '0304776221', N'33 An Sương', 'nghiapt@gmail.com', 'STAFF'
	, '2000-05-23', '2023-04-26', 'SA5', 'SA6', '017363618581', null, null, true);
    
INSERT INTO Contact VALUES('CONT1', N'Email', '20110560@student.hcmute.edu.vn','ACC5', true);
INSERT INTO Contact VALUES('CONT2', N'Phone', '0804066991', 'ACC5', true);
INSERT INTO Contact VALUES('CONT3', N'Facebook','https://www.facebook.com/enochphan.99/', 'ACC5', true);
INSERT INTO Contact VALUES('CONT4', N'Email', 'hoangtd@gmail.com', 'ACC3', true);
INSERT INTO Contact VALUES('CONT5', N'Phone', '0798238902', 'ACC3', true);
INSERT INTO Contact VALUES('CONT6', N'Facebook','https://www.facebook.com/enochphan.99/duyhoangta/', 'ACC3', true);

INSERT INTO Report VALUES('REP1', N'Hoàng Văn Nam', 'namhv@gmail.com', '0976543213', N'Shipper giao hàng nhưng lại tỏ thái độ với Khách Hàng',false,'2023-04-28 09:06:45', 'ACC1', true);
INSERT INTO Report VALUES('REP2', N'Hoàng Văn Cao', 'caohv@gmail.com', '0556447998', N'Chỉ hỏi shipper sao giao hàng muộn nhưng lại bị mắng ?',false,'2023-04-27 09:06:45', 'ACC6', true);
INSERT INTO Report VALUES('REP3', N'Lê Hoàng', 'haongle@gmail.com', '0993445778', N'Đặt ly trà sữa mà 4 tiếng đồng hồ đơn vẫn chưa được xử lý ?',false,'2023-04-27 011:08:37', null, true);
    
INSERT INTO work_day VALUES('2023-04-28', 0, true);
INSERT INTO work_day VALUES('2023-04-29', 0, true);
INSERT INTO work_day VALUES('2023-04-30', 1, true);
INSERT INTO work_day VALUES('2023-05-01', 1, true);

INSERT INTO staff_work_day VALUES('789123678352', '2023-04-28', 11);
INSERT INTO staff_work_day VALUES('872515267382', '2023-04-28', 10);
INSERT INTO staff_work_day VALUES('952357362740', '2023-04-28', 8);
INSERT INTO staff_work_day VALUES('826167293461', '2023-04-28', 8);
INSERT INTO staff_work_day VALUES('017363618581', '2023-04-28', 8);
INSERT INTO staff_work_day VALUES('789712346656', '2023-04-28', 9);

INSERT INTO Milk_tea_category VALUES('CATE1', N'Trà Sủi Bọt', 
	N'Trà sủi bọt bắt nguồn từ Đài Loan, Trung Quốc vào những năm 1980. Kể từ đó, thức uống này bỗng trở thành đồ uống truyền thống của Đài Loan. Do quá trình lắc trong khi pha chế tạo thành bọt nên nó đã được gọi tên là trà sủi bọt. Trà sủi bọt là thức uống rất được ưa thích ở giới trẻ hiện nay !', true);
INSERT INTO Milk_tea_category VALUES('CATE2', N'Trà Con Gái', 
	N'Menu Trà Con Gái với 6 loại Trà ngọt ngào - thơm - dịu dàng - cá tính - xinh đẹp - thanh mát như 6 đặc điểm dễ thương của con gái.', true);
INSERT INTO Milk_tea_category VALUES('CATE3', N'Trà Sữa', 
	N'Trà sữa Ba Con Báo thơm ngon, mới lạ với đa dạng các loại hương vị sẽ mang đến cho bạn cảm giác khó quên. Với nguồn nguyên liệu chọn lọc kĩ càng từ Hàn Quốc, ly trà sữa được phục vụ sẽ không khiến bạn thất vọng.', true);
INSERT INTO Milk_tea_category VALUES('CATE4', N'Trà Tươi', 
	N'Một cây trà nếu được trồng ở những vùng đất có độ cao và khí hậu khác nhau thì sẽ thu được những loại trà cũng khác nhau. Có thể thấy sự phức tạp đến từ phía bên trong, từ những thành phần cũng như cấu tạo hoá học độc nhất vô nhị mà chỉ mình cây trà có được. Thấu hiểu điều đó, để giữ trọn vị tươi nguyên, bảo toàn dưỡng chất tốt nhất, một búp và hai lá non thường được chúng tôi thu hái vào thời điểm sáng sớm. Tiếp đến, quy trình sản xuất để cho ra các sản phẩm trà chất lượng cũng được thực hiện khép kín.', true);
INSERT INTO Milk_tea_category VALUES('CATE5', N'Trà Đặc Biệt', 
	N'Những ly trà được pha chế một cách tỉ mỉ, kết hợp những vị đặc biệt tạo cho bạn một trải nghiệm mới mẻ, mang đến cho bạn hương vị không thể chối từ.', true);
INSERT INTO Milk_tea_category VALUES('CATE6', N'Kem Tuyết', 
	N'Kem Tuyết là một món không còn gì xa lạ đối với những tín đồ chuyên uống trà sữa. Đặc biệt vào những ngày nóng bức, còn gì tuyệt vời một ly kem tuyết giải nhiệt ở Ba Con Báo đúng không nè.', true);

INSERT INTO Add_on VALUES('ADD1', N'Thạch Sữa Tươi', 5000, 500, true);
INSERT INTO Add_on VALUES('ADD2', N'Thạch Sương Sáo', 5000, 500, true);
INSERT INTO Add_on VALUES('ADD3', N'Thạch Sô Cô La', 5000, 500, true);
INSERT INTO Add_on VALUES('ADD4', N'Thủy tinh Kiwi', 8000, 800, true);
INSERT INTO Add_on VALUES('ADD5', N'Thạch Flan', 5000, 500, true);
INSERT INTO Add_on VALUES('ADD6', N'Trân Châu Đen', 8000, 800, true);
INSERT INTO Add_on VALUES('ADD7', N'Thủy Tinh Chanh Dây', 8000, 800, true);
INSERT INTO Add_on VALUES('ADD8', N'Nha Đam', 5000, 500, true);
INSERT INTO Add_on VALUES('ADD9', N'Sủi Bọt', 15000, 1500, true);
INSERT INTO Add_on VALUES('ADD10', N'Hạt Trái Cây', 8000, 800, true);
INSERT INTO Add_on VALUES('ADD11', N'Thủy Tinh Dâu', 8000, 800, true);
INSERT INTO Add_on VALUES('ADD12', N'Sủi Bọt Phô Mai', 15000, 1500, true);
INSERT INTO Add_on VALUES('ADD13', N'Hạt Đẹp', 10000, 1000, true);
INSERT INTO Add_on VALUES('ADD14', N'Hạt Đường Đen', 10000, 1000, true);
INSERT INTO Add_on VALUES('ADD15', N'Thủy Tinh Ya-ua', 8000, 800, true);
INSERT INTO Add_on VALUES('ADD16', N'Thủy Tinh Nguyên Vị', 8000, 800, true);
INSERT INTO Add_on VALUES('ADD17', N'Thủy Tinh Vải', 8000, 800, true);

INSERT INTO Milk_tea VALUES('MTEA1', N'Trà Bí Đao Sủi Bọt', 36000, 3600,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sui%20Bot%2Ftrabidao_suibot.jpg?alt=media&token=29b9a5f2-ebb0-4779-805f-89955ce74a47' , 'CATE1', true);
INSERT INTO Milk_tea VALUES('MTEA2', N'Trà Xanh Sủi Bọt', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sui%20Bot%2Ftraxanh_suibot.jpg?alt=media&token=2bee4623-711d-423e-881f-3fb70a78cfd7' , 'CATE1', true);
INSERT INTO Milk_tea VALUES('MTEA3', N'Hồng Trà Sủi Bọt', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sui%20Bot%2Fhongtra_suibot.jpg?alt=media&token=12aafc83-e2a7-49b3-9ece-caf7937b1260', 'CATE1', true);
INSERT INTO Milk_tea VALUES('MTEA4', N'Trà Alisan Sủi Bọt', 41000, 4100,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sui%20Bot%2Ftraalisan_suibot.jpg?alt=media&token=8ffe32dc-d81a-4255-9818-e87b71f56054', 'CATE1', true);
INSERT INTO Milk_tea VALUES('MTEA5', N'Trà Gạo Nâu Sủi Bọt', 41000, 4100,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sui%20Bot%2Ftragaonau_suibot.jpg?alt=media&token=99a36510-472d-4ac3-a531-e63fc342a2c2', 'CATE1', true);
INSERT INTO Milk_tea VALUES('MTEA6', N'Trà Quan Âm Sủi Bọt', 41000, 4100,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sui%20Bot%2Ftraquanam_suibot.jpg?alt=media&token=fec36802-0667-4023-bc46-e5933fea6c33', 'CATE1', true);
INSERT INTO Milk_tea VALUES('MTEA7', N'Trà Ô Long Sủi Bọt', 41000, 4100,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sui%20Bot%2Ftraolong_suibot.jpg?alt=media&token=0029b4ba-c0e2-4c6b-99e0-b733fd3500c1', 'CATE1', true);
 INSERT INTO Milk_tea VALUES('MTEA8', N'Trà Hoa Sủi Bọt', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sui%20Bot%2Ftrahoa_suibot.jpg?alt=media&token=8a1b39b3-7122-47e0-b4a1-b36932a247a5', 'CATE1', true); 
INSERT INTO Milk_tea VALUES('MTEA9', N'Trà Gạo Nâu', 35000, 3500,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Con%20Gai%2Ftragao_nau.jpg?alt=media&token=0c6afc95-7017-4349-8ad9-82ea4ebc8c12', 'CATE2', true);  
INSERT INTO Milk_tea VALUES('MTEA10', N'Trà Hoa Lục Trà', 35000, 3500,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Con%20Gai%2Ftrahoa_luctra.jpg?alt=media&token=7e48ca9b-832c-4af5-ab9d-aa1768f64837', 'CATE2', true); 
INSERT INTO Milk_tea VALUES('MTEA11', N'Trà Mật Ong Nha Đam', 35000, 3500,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Con%20Gai%2Ftramatong_nhadam.jpg?alt=media&token=96dbfd31-bc95-4d3a-84ed-3e146a21e87a', 'CATE2', true); 
INSERT INTO Milk_tea VALUES('MTEA12', N'Trà Blueberry', 41000, 4100,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Con%20Gai%2Ftrablueberry.jpg?alt=media&token=0f9cbe24-cfd7-44d5-b69c-58aa9426ed41', 'CATE2', true); 
INSERT INTO Milk_tea VALUES('MTEA13', N'Trà Đẹp', 41000, 4100,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Con%20Gai%2Ftradep.jpg?alt=media&token=d383971e-0213-4e87-9520-fbd4ec52ee7d', 'CATE2', true); 
INSERT INTO Milk_tea VALUES('MTEA14', N'Trà Bưởi', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Con%20Gai%2Ftra_buoi.jpg?alt=media&token=059575a4-5609-4dbc-8fa2-79768908024c', 'CATE2', true); 
INSERT INTO Milk_tea VALUES('MTEA15', N'Trà Sữa Bí Đao', 29000, 2900,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_bidao.jpg?alt=media&token=626bedbd-576e-4cb1-a50e-c58ec00b9653', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA16', N'Trà Sữa Hoa Lục Trà', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_hoaluctra.jpg?alt=media&token=80f07849-94b2-4520-a33e-5362a1bbd30f', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA17', N'Trà Sữa BaConBao', 29000, 2900,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_baconbao.jpg?alt=media&token=b087f9a2-c452-47bf-8dbe-97e1c3bd96bd', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA18', N'Trà Sữa Gạo Nâu', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_gaonau.jpg?alt=media&token=e4d60532-7ffc-46c9-9e90-c354b9e624cc', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA19', N'Trà Sữa Vải', 29000, 2900,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_vai.jpg?alt=media&token=1116b433-d2b5-4a51-9ec5-b697d433e55d', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA20', N'Trà Sữa 3Q', 34000, 3400,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_3q.jpg?alt=media&token=7f275a7e-3cf7-4226-89f1-5e2c7fbae166', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA21', N'Trà Sữa Trà Xanh', 29000, 2900,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_traxanh.jpg?alt=media&token=a1402517-d9bc-43fc-aa8e-562998dbde71', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA22', N'Trà Sữa Kiwi', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_kiwi.jpg?alt=media&token=b2d6d1a2-02e4-4d89-bd71-96d16dd00340', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA23', N'Trà Sữa Trân Châu', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_tranchau.jpg?alt=media&token=75294677-fb8d-4562-b9ee-10f6039ad798', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA24', N'Trà Sữa Darjeeling', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_dajeeling.jpg?alt=media&token=9446f6fd-a001-4ba6-b7b3-f67d34bd25d5', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA25', N'Trà Sữa Dâu Tây', 29000, 2900,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_dautay.jpg?alt=media&token=95b7cb16-fd71-4c58-9bcd-d0a05f418f85', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA26', N'Trà Sữa Cà Phê', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_caphe.jpg?alt=media&token=c1a713dd-f27d-4945-b717-cab0782967a4', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA27', N'Trà Sữa Ô Long', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_olong.jpg?alt=media&token=444cdf06-c5e2-4acc-9490-bc9b4f3c458d', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA28', N'Trà Sữa Bạc Hà', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_bacha.jpg?alt=media&token=b6008d24-2413-4adc-9f84-de747701f7be', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA29', N'Trà Sữa Taichi', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_taichi.jpg?alt=media&token=234a266c-45f3-4254-981f-329a5e2b1e30', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA30', N'Trà Sữa Đào', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Sua%2Ftrasua_dao.jpg?alt=media&token=3ac7d5d6-0714-43b6-bea7-9ae8f97a6b58', 'CATE3', true); 
INSERT INTO Milk_tea VALUES('MTEA31', N'Trà Bí Đao', 28000, 2800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Tuoi%2Ftra_bidao.jpg?alt=media&token=e4b5603d-e72b-4822-ad10-5bf3f0569429', 'CATE4', true); 
INSERT INTO Milk_tea VALUES('MTEA32', N'Hồng Trà Ceylon', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Tuoi%2Fhongtra_ceylon.jpg?alt=media&token=ac141ac0-9a41-40cf-9bb6-043a6d3bb075', 'CATE4', true); 
INSERT INTO Milk_tea VALUES('MTEA33', N'Trà Xanh BaConBao', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Tuoi%2Ftraxanh_baconbao.jpg?alt=media&token=0fb95e43-919a-4514-a0db-114610cd78ae', 'CATE4', true); 
INSERT INTO Milk_tea VALUES('MTEA34', N'Trà Cao Sơn Ô Long', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Tuoi%2Ftra_caoson_olong.jpg?alt=media&token=f95afebf-9881-4565-a1a9-30ad16f2d420', 'CATE4', true); 
INSERT INTO Milk_tea VALUES('MTEA35', N'Cao Sơn Trà Tươi', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Tuoi%2Fcaoson_tratuoi.jpg?alt=media&token=abd939f3-f763-441f-b99f-083179dab2d0', 'CATE4', true); 
INSERT INTO Milk_tea VALUES('MTEA36', N'Hồng Trà Dajeeling', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Tuoi%2Fhongtra_dajeeling.jpg?alt=media&token=5e1f3024-1941-4b24-a593-3a59139c0dcb', 'CATE4', true); 
INSERT INTO Milk_tea VALUES('MTEA37', N'Trà Quan Âm', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Tuoi%2Ftra_quanam.jpg?alt=media&token=84a6f370-4703-4ea6-9c91-ca9bd71105e4', 'CATE4', true); 
INSERT INTO Milk_tea VALUES('MTEA38', N'Trà Alishan Lạnh', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Tra%20Tuoi%2Ftra_alishan_lanh.jpg?alt=media&token=588dbb34-de4a-4aa0-8bd3-5febbd4ab264', 'CATE4', true); 
INSERT INTO Milk_tea VALUES('MTEA39', N'Trà Xanh Xí Muội', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftraxanh_ximuoi.jpg?alt=media&token=00cca5a9-aa19-434c-922d-3e9e8c2ea37e', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA40', N'Trà Xanh Mật Ong Chanh', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftraxanh_matongchanh.jpg?alt=media&token=46b0ca35-24ce-4cab-bfff-781a00349d44', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA41', N'Trà Xanh Chanh Dây', 32000, 3200,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftraxanh_chanhday.jpg?alt=media&token=4e447656-c61d-4b4f-a1a3-0607586350de', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA42', N'Trà Xanh Xoài', 35000, 3500,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftraxanh_xoai.jpg?alt=media&token=e8e6d01a-540f-4f1f-a6ed-5013ca4623ad', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA43', N'Trà Đào', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftra_dao.jpg?alt=media&token=4a831282-00b7-4800-9fca-91980090c576', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA44', N'Trà Xanh Kiwi', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftraxanh_kiwi.jpg?alt=media&token=3771ae27-d208-4307-9d4a-d48d02d32235', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA45', N'Trà Vải', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftra_vai.jpg?alt=media&token=b788659d-9148-461d-9823-55555bf7166b', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA46', N'Trà Raspberry', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftra_raspberry.jpg?alt=media&token=bf0b558a-3b2d-4525-aa36-81d5c0e665f7', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA47', N'Hồng Trà Dâu', 35000, 3500,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Fhongtra_dau.jpg?alt=media&token=ff31c32e-742a-4615-ba18-c49fa096c0e7', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA48', N'Trà Thanh Xuân', 35000, 3500,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Dac%20Biet%2Ftra_thanhxuan.jpg?alt=media&token=e78e0a54-ad3c-4610-858d-0c2b3cb5b645', 'CATE5', true); 
INSERT INTO Milk_tea VALUES('MTEA49', N'Kem Tuyết Sô Cô La', 38000, 3800,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Kem%20Tuyet%2Fkemtuyet_socola.jpg?alt=media&token=2b0f1d0b-a16f-4a79-92fc-68167e66728a', 'CATE6', true); 
INSERT INTO Milk_tea VALUES('MTEA50', N'Kem Tuyết Trà Xanh Nhật Bản', 44000, 4400,
'https://firebasestorage.googleapis.com/v0/b/projectooad-651f1.appspot.com/o/Kem%20Tuyet%2Fkemtuyet_traxanh_nhatban.jpg?alt=media&token=a2f42f9e-f36c-4f2d-9670-63f689046cc0', 'CATE6', true); 

INSERT INTO blog VALUES ('BLOG1', '2023-05-01 12:35:40', 'Trà sữa mới ra hôm nay', 'Hot hot hot, mại dô', 'https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/FE3D47059BF7438C9DA604F8CF42F707/106108544_3237044136372535_4939440858945513540_o-1.jpg', 'ACC2', true);

INSERT INTO ordering VALUES ('ORD1', N'Sơn Phan', N'Trung QUốc', '03338444577', 'COD', '2023-05-01 12:35:40',
	'65000', null, 'Phan Hồng Sơn', 'PassedToShipper', null, 'ACC3', 'ACC6', true);
INSERT INTO ordering VALUES ('ORD2', N'Sơn Phan', N'Trung QUốc', '03338444577', 'COD', '2023-05-03 12:35:40',
	'70000', null, 'Phan Hồng Sơn', 'PassedToShipper', null, 'ACC3', 'ACC6', true);
    
INSERT INTO custom_milk_tea VALUES('CMTEA1', 'MTEA50', 50, 50, 'L', 6500, 65000, 1, 'ORD1', true);
INSERT INTO custom_milk_tea VALUES('CMTEA2', 'MTEA50', 50, 50, 'L', 3000, 30000, 2, 'ORD1', true);


    

    
    

    
    