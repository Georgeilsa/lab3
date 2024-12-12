const terms = {
    popolnyaemyy: [
        { term: '6 месяцев', rate: 20 },
        { term: '1 год', rate: 22 },
        { term: '1.5 года', rate: 15 },
        { term: '2 года', rate: 10 }
    ],
    srochnyy: [
        { term: '3 месяца', rate: 20 },
        { term: '6 месяцев', rate: 22 },
        { term: '9 месяцев', rate: 23 },
        { term: '1 год', rate: 24 },
        { term: '1.5 года', rate: 18 },
        { term: '2 года', rate: 15 }
    ]
};

function updateTerms() {
    const depositType = document.getElementById('depositType').value;
    const termSelect = document.getElementById('term');

    // Очистка предыдущих вариантов
    termSelect.innerHTML = '';

    if (depositType) {
        const availableTerms = terms[depositType];
        
        availableTerms.forEach(term => {
            const option = document.createElement('option');
            option.value = term.rate; // Используем ставку как значение
            option.textContent = term.term;
            termSelect.appendChild(option);
        });

        termSelect.disabled = false; // Активируем селектор сроков
    } else {
        termSelect.disabled = true; // Деактивируем селектор сроков
        termSelect.innerHTML = '<option value="">--Сначала выберите вид вклада--</option>';
    }
}

document.getElementById('depositForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const depositType = document.getElementById('depositType').value;
    const termRate = document.getElementById('term').value;
    const amount = parseFloat(document.getElementById('amount').value);

    if (!depositType || !termRate || isNaN(amount) || amount <= 0) {
        alert('Пожалуйста, заполните все поля корректно.');
        return;
    }

    const selectedTerm = document.querySelector('#term option:checked').textContent;
    const interestRate = parseFloat(termRate) / 100;

    // Расчет итоговой суммы
    const finalAmount = amount * (1 + interestRate);
    
    document.getElementById('result').textContent = 
    document.getElementById('result').textContent = 
    "Вы выбрали"+ depositType === 'popolnyaemyy' ? 'Пополняемый' : 'Cрочный'+" вклад на срок "+selectedTerm+" ,ваша сумма вклада составит " +amount+" рублей, а итоговая сумма через срок будет "+ finalAmount.toFixed(2)+" рублей.";
});