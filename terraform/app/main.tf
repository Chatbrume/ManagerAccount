/*******************************************************************************/
/*                                   MODULES                                   */
/*******************************************************************************/

# Appel du module de création de ec2
module "ec2" {
  source              = "../modules/ec2"
  author_name         = var.author_name
  instance_type       = var.instance_type
  private_key_path    = var.private_key_path
  availability_zone   = var.ec2_avail_zone
  sg_name             = module.sg.out-sg-name
  public_ip           = module.eip.out_eip_ip
  main_directory      = var.main_dir
}

#Appel du module de création du sg
module "sg" {
  source   = "../modules/sg"
  tag_name = var.author_name
}

# Appel du module de création de l'adresse ip pulique
module "eip" {
  source      = "../modules/eip"
  author_name = var.author_name
}

/*******************************************************************************/
/*                                  RESOURCES                                  */
/*******************************************************************************/

resource "aws_eip_association" "eip_association" {
  allocation_id = module.eip.out_eip_id
  instance_id   = module.ec2.out-ec2-id
}