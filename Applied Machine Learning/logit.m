S= linspace(0, 1, 100);
x= log(S./(1-S));
plot(S, S);
xlabel("Sigmoid")
ylabel("Logit function")