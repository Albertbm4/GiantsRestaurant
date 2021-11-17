const { test, expect } = require('@playwright/test');

test('Global frontend test', async ({ page }) => {
  await page.goto('http://localhost:3000/');

  await expect(page).toHaveTitle('React App');

  const htmlPage = page.locator('html').first();
  await expect(htmlPage).toHaveAttribute('lang', 'en');

  const carrousel = page.locator('div.react-multi-carousel-list').first();
  const carrouselList = carrousel.locator('ul').first();
  await expect(carrouselList).toHaveAttribute('class','react-multi-carousel-track ');

  const listItem = carrouselList.locator('li').first();
  await expect(listItem).toBeVisible();
  await expect(listItem).toHaveAttribute('aria-hidden', 'false');
  await expect(listItem).toHaveAttribute('class','react-multi-carousel-item react-multi-carousel-item--active ');
  await expect(listItem).toHaveAttribute('data-index', '0');
  const button = listItem.locator('button').first();
  await expect(button).toHaveAttribute('disabled', '');
  await page.click('text=Opened');

  const nextButton = page.locator('button.react-multiple-carousel__arrow').first();
  await expect(nextButton).toHaveAttribute('aria-label', 'Go to next slide');

  const map = page.locator('div.map-container').first();
  await expect(map).toBeVisible();



});



