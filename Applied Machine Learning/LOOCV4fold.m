%LOOCV with 4 folds
x= linspace(0,pi,100);
y= 2* sin(x);
%Training data for 4 folds leaving one out
tdx1= x(1: 75);
tdx2= [x(1: 50),x(76: 100)];
tdx3= [x(1:25), x(51: 100)];
tdx4= x(26: 100);

tdy1= y(1: 75);
tdy2= [y(1: 50),y(76: 100)];
tdy3= [y(1:25), y(51: 100)];
tdy4= y(26: 100);
%Corresponding validation data
vd1= x(76: 100);
vd2= x(51: 75);
vd3= x(26: 50);
vd4= x(1: 25);


Loss=zeros(1,4);
for n= 1:4
%Generate model with training data
p1=polyfit(tdx1,tdy1,n);
p2=polyfit(tdx2,tdy2,n);
p3=polyfit(tdx3,tdy3,n);
p4=polyfit(tdx4,tdy4,n);
%Generate values for validation data
val1= polyval(p1, vd1);
val2= polyval(p2, vd2);
val3= polyval(p3, vd3);
val4= polyval(p4, vd4);
%Generate values for training data
valt1= polyval(p1, tdx1);
valt2= polyval(p2, tdx2);
valt3= polyval(p3, tdx3);
valt4= polyval(p4, tdx4);
%Calculate Loss
L1= mean((y(76: 100)-val1).^2);
L2= mean((y(51: 75)-val2).^2);
L3= mean((y(26: 50)-val3).^2);
L4= mean((y(1: 25)-val4).^2);
%Total loss
L= mean([L1 L2 L3 L4]);
Loss(n)=L;

%Plot graph
figure

subplot(1,4,1);
plot(x,y);
hold on;
plot(tdx1, valt1,'--');
hold on;
plot(vd1, val1);
legend('Original','Trained','Verified');

subplot(1,4,2);
plot(x,y);
hold on;
plot(tdx2, valt2,'--');
hold on;
plot(vd2, val2);
legend('Original','Trained','Verified');

subplot(1,4,3);
plot(x,y);
hold on;
plot(tdx3, valt3,'--');
hold on;
plot(vd3, val3);
legend('Original','Trained','Verified');

subplot(1,4,4);
plot(x,y);
hold on;
plot(tdx4, valt4,'--');
hold on;
plot(vd4, val4);
legend('Original','Trained','Verified');
end
order= 1:4;
disp(Loss);
figure
bar(order,Loss);
axis([0 5 0 0.25]);