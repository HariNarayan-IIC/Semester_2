x = linspace(0, pi, 100);  % Adjust the range of x to [0, ?]
y_actual = 2*(x - (x.^3)/6 + (x.^5)/120);

% Polynomial regression for different orders
for order = 1:4
    p = polyfit(x, y_actual, order);
    y_fit = polyval(p, x);
    
    % Calculate loss (mean squared error)
    loss = mean((y_actual - y_fit).^2);
    
    fprintf('Order %d: Loss = %.4f\n', order, loss);
end
