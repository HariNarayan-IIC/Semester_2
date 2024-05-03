x= linspace(0,pi,100);
y= 2* sin(x);

%First order
p1= polyfit(x,y,1);
y1= polyval(p1,x);
subplot(1,4,1);
plot(x,y);
axis([0 pi 0 2]);
hold on;
plot(x,y1);
hold on;
hold off;
L1= mean((y-y1).^2);

%Second order
p2= polyfit(x,y,2);
y2= polyval(p2,x);
subplot(1,4,2);
plot(x,y);
axis([0 pi 0 2]);
hold on;
plot(x,y2);
hold on;
hold off
L2= mean((y-y2).^2);

%Third order
p3= polyfit(x,y,3);
y3= polyval(p3,x);
subplot(1,4,3);
plot(x,y);
axis([0 pi 0 2]);
hold on;
plot(x,y3);
hold on;
hold off;
L3= mean((y-y3).^2);

%Fourth order
p4= polyfit(x,y,4);
y4= polyval(p4,x);
subplot(1,4,4);
plot(x,y);
axis([0 pi 0 2]);
hold on;
plot(x,y4);
hold on;
hold off;
L4= mean((y-y4).^2);

Loss= [L1 L2 L3 L4];
order= 1:4;
disp(Loss);

figure
bar(order, Loss);
axis([0 5 0 0.1]);