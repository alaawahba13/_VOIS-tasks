import pandas as pd


#Load the data inside the provided CSV file into a Data Frame 
df = pd.read_csv("Employees.csv")
#1- Remove any duplicates in the table
df.drop_duplicates(inplace=True)
# 2- Remove any decimal places in the Age column
df = df.astype({'Age':'int'})
# 3- Convert the USD salary to EGP
df['Salary(USD)'] *= 48.8
df = df.rename(columns={'Salary(USD)':'Salary(EGP)'})
# 4- Print in the console some stats like:
# 	- Average age
avg_age = df['Age'].mean()
# 	- Median Salaries
median_salaries = df['Salary(EGP)'].median()
# 	- Ratio between males and female employees
gender_counts = df['Gender'].value_counts()
female_count = gender_counts.get('F', 0)
male_count = gender_counts.get('M', 0)
ratio = male_count / female_count


print(f"Average age is :{avg_age:.2f}")   
print(f"Median Salaries is :{median_salaries:.2f}")
print(f"Ratio between M to F is: {male_count}:{female_count} or {ratio:.2f}")

# 5- Write the data in a new CSV file
df.to_csv("newEmployees.csv", index=False)
